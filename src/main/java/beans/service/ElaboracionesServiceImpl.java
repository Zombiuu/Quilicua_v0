package beans.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.dao.ConservacionesDAO;
import beans.dao.ElaboracionesDAO;
import beans.dao.MatPrimaDAO;
import beans.dao.RelacionElaboracionMatPrimasDAO;
import beans.dto.ConservacionesDTO;
import beans.dto.ElaboracionesDTO;
import beans.dto.MateriasPrimasDTO;
import beans.model.Elaboraciones;
import beans.model.MateriasPrimas;
import beans.model.RelElaboracionesMateriasPrimas;


@Service("elaboracionesService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { ServiceException.class,
		RuntimeException.class })
public class ElaboracionesServiceImpl implements ElaboracionesService {

	@Autowired
	@Qualifier("matPrimaDAO")
	private MatPrimaDAO matPrimaDAO;

	@Autowired
	@Qualifier("conservacionesDAO")
	private ConservacionesDAO conservacionesDAO;

	@Autowired
	@Qualifier("elaboracionesDAO")
	private ElaboracionesDAO elaboracionesDAO;
	
	@Autowired
	@Qualifier("relacionElaboracionMatPrimasDAO")
	private RelacionElaboracionMatPrimasDAO relElaboracionesMateriasPrimasDAO;

	@Override
	public List<MateriasPrimasDTO> obtenerMatPrimas() throws ServiceException {
		List<MateriasPrimasDTO> listaMatPrimas = new ArrayList<MateriasPrimasDTO>();
		try {
			listaMatPrimas = this.matPrimaDAO.obtenerMatPrimas();
		} catch (ServiceException se) {
			throw new ServiceException(se.getMessage());
		}

		return listaMatPrimas;
	}

	public MatPrimaDAO getMatPrimaDAO() {
		return matPrimaDAO;
	}

	public void setMatPrimaDAO(MatPrimaDAO matPrimaDAO) {
		this.matPrimaDAO = matPrimaDAO;
	}

	@Override
	public List<ConservacionesDTO> obtenerConservaciones() throws ServiceException {
		List<ConservacionesDTO> listaConservaciones = new ArrayList<ConservacionesDTO>();
		try {
			listaConservaciones = this.conservacionesDAO.obtenerConservaciones();
		} catch (ServiceException se) {
			throw new ServiceException(se.getMessage());
		}
		return listaConservaciones;
	}

	public ConservacionesDAO getConservacionesDAO() {
		return conservacionesDAO;
	}

	public void setConservacionesDAO(ConservacionesDAO conservacionesDAO) {
		this.conservacionesDAO = conservacionesDAO;
	}

	public ElaboracionesDAO getElaboracionesDAO() {
		return elaboracionesDAO;
	}

	public void setElaboracionesDAO(ElaboracionesDAO elaboracionesDAO) {
		this.elaboracionesDAO = elaboracionesDAO;
	}
	
	

	public RelacionElaboracionMatPrimasDAO getRelElaboracionesMateriasPrimasDAO() {
		return relElaboracionesMateriasPrimasDAO;
	}

	public void setRelElaboracionesMateriasPrimasDAO(RelacionElaboracionMatPrimasDAO relElaboracionesMateriasPrimasDAO) {
		this.relElaboracionesMateriasPrimasDAO = relElaboracionesMateriasPrimasDAO;
	}

	@Override
	public void guardar(ElaboracionesDTO elaboracionDTO) throws ServiceException {
		try {
			Elaboraciones elaboracion = this.mapearDTOaEntidad(elaboracionDTO);
			this.elaboracionesDAO.guardar(elaboracion);
			Set<RelElaboracionesMateriasPrimas>  rel = this.mapearRelElaboracionMatprimas(elaboracionDTO, elaboracion);
			for (RelElaboracionesMateriasPrimas relElaboracionesMateriasPrimas : rel) {
				this.relElaboracionesMateriasPrimasDAO.guardar(relElaboracionesMateriasPrimas);
			}
		} catch (ServiceException se) {
			throw new ServiceException(se.getMessage());
		}

	}

	private Elaboraciones mapearDTOaEntidad(ElaboracionesDTO elaboracionDTO) throws ServiceException {
		Elaboraciones elaboracion = new Elaboraciones();
		elaboracion.setNombre(elaboracionDTO.getNombre());
		try {
			elaboracion.setCatConservaciones(
					this.conservacionesDAO.obtenerConservacion(elaboracionDTO.getValueConservacion()));
		} catch (ServiceException se) {
			throw new ServiceException(se.getMessage());
		}

		elaboracion.setBorrado("N");

	
		

		return elaboracion;

	}
	
	public Set<RelElaboracionesMateriasPrimas> mapearRelElaboracionMatprimas(ElaboracionesDTO elaboracionDTO, Elaboraciones elaboraciones) {
		Set<RelElaboracionesMateriasPrimas> hsElaboracionesMatPrimas = new HashSet<RelElaboracionesMateriasPrimas>();

		for (int i = 0; i < elaboracionDTO.getMateriasPrimas().size(); i++) {

			RelElaboracionesMateriasPrimas relElaboracionesMateriasPrimas = new RelElaboracionesMateriasPrimas();
			relElaboracionesMateriasPrimas.setBorrado("N");
			MateriasPrimasDTO matPrimaDTO = elaboracionDTO.getMateriasPrimas().get(i);
		
			MateriasPrimas matPrima = this.matPrimaDAO
					.obtenerMateriaPrima(matPrimaDTO.getIdMatPrima());

			relElaboracionesMateriasPrimas.setMateriasPrimas(matPrima);
			relElaboracionesMateriasPrimas.setElaboraciones(elaboraciones);
			hsElaboracionesMatPrimas.add(relElaboracionesMateriasPrimas);
		}
		
		return hsElaboracionesMatPrimas;
		
		
		
		
		
	}

}
