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

import beans.dao.ElaboracionesDAO;
import beans.dao.PlatosDAO;
import beans.dao.RelacionPlatosElaboracionesDAO;
import beans.dao.TipoPlatoDAO;
import beans.dto.ElaboracionesDTO;
import beans.dto.MateriasPrimasDTO;
import beans.dto.PlatosDTO;
import beans.dto.TipoPlatoDTO;
import beans.model.Elaboraciones;
import beans.model.MateriasPrimas;
import beans.model.Platos;
import beans.model.RelElaboracionesMateriasPrimas;
import beans.model.RelPlatosElaboraciones;


@Service("platosService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { ServiceException.class,
		RuntimeException.class })
public class PlatosServiceImpl implements PlatosService {

	

	@Autowired
	@Qualifier("elaboracionesDAO")
	private ElaboracionesDAO elaboracionesDAO;
	
	@Autowired
	@Qualifier("tipoPlatoDAO")
	private TipoPlatoDAO tipoPlatoDAO;
	
	@Autowired
	@Qualifier("platosDAO")
	private PlatosDAO platosDAO;
	
	@Autowired
	@Qualifier("relacionPlatosElaboracionesDAO")
	private RelacionPlatosElaboracionesDAO relacionPlatosElaboracionesDAO;
	
	
	


	

	private Platos mapearDTOaEntidad(PlatosDTO platosDTO) throws ServiceException {
		Platos platos = new Platos();
		platos.setNombre(platosDTO.getNombre());
		try {
			platos.setCatTipoPlato(this.tipoPlatoDAO.obtenerTipoPlato(platosDTO.getTipoPlato()));
					
		} catch (ServiceException se) {
			throw new ServiceException(se.getMessage());
		}

		platos.setBorrado("N");


		return platos;

	}
	
	public Set<RelPlatosElaboraciones> mapearRelPlatoElaboraciones(PlatosDTO platosDTO, Platos platos) {
		Set<RelPlatosElaboraciones> hsRelPlatosElaboraciones = new HashSet<RelPlatosElaboraciones>();

		for (int i = 0; i < platosDTO.getElaboraciones().size(); i++) {

			RelPlatosElaboraciones relPlatosElaboraciones = new RelPlatosElaboraciones();
			relPlatosElaboraciones.setBorrado("N");
			ElaboracionesDTO elaboracionesDTO = platosDTO.getElaboraciones().get(i);
		
			Elaboraciones elaboracion = this.elaboracionesDAO
					.obtenerElaboracion((elaboracionesDTO.getId()));

			relPlatosElaboraciones.setElaboraciones(elaboracion);
			relPlatosElaboraciones.setPlatos(platos);
			hsRelPlatosElaboraciones.add(relPlatosElaboraciones);
		}
		
		return hsRelPlatosElaboraciones;
		
		
		
		
		
	}
	
	@Override
	public List<TipoPlatoDTO> obtenerTipoPlato() throws ServiceException {
		List<TipoPlatoDTO> listaTipoPlato = new ArrayList<TipoPlatoDTO>();
		try {
			listaTipoPlato = this.tipoPlatoDAO.obtenerListaTipoPlato();
		} catch (ServiceException se) {
			throw new ServiceException(se.getMessage());
		}
		return listaTipoPlato;
	}




	@Override
	public List<ElaboracionesDTO> obtenerElaboraciones() throws ServiceException {
		List<ElaboracionesDTO> listaElaboraciones = new ArrayList<ElaboracionesDTO>();
		try {
			listaElaboraciones = this.elaboracionesDAO.obtenerElaboraciones();
		} catch (ServiceException se) {
			throw new ServiceException(se.getMessage());
		}

		return listaElaboraciones;
	}





	@Override
	public void guardar(PlatosDTO platosDTO) throws ServiceException {
		try {
			Platos plato = this.mapearDTOaEntidad(platosDTO);
			this.platosDAO.guardar(plato);
			Set<RelPlatosElaboraciones>  rel = this.mapearRelPlatoElaboraciones(platosDTO, plato);
			for (RelPlatosElaboraciones relPlatosElaboraciones : rel) {
				this.relacionPlatosElaboracionesDAO.guardar(relPlatosElaboraciones);
			}
		} catch (ServiceException se) {
			throw new ServiceException(se.getMessage());
		}

	}



	public ElaboracionesDAO getElaboracionesDAO() {
		return elaboracionesDAO;
	}



	public void setElaboracionesDAO(ElaboracionesDAO elaboracionesDAO) {
		this.elaboracionesDAO = elaboracionesDAO;
	}



	public RelacionPlatosElaboracionesDAO getRelacionPlatosElaboracionesDAO() {
		return relacionPlatosElaboracionesDAO;
	}



	public void setRelacionPlatosElaboracionesDAO(RelacionPlatosElaboracionesDAO relacionPlatosElaboracionesDAO) {
		this.relacionPlatosElaboracionesDAO = relacionPlatosElaboracionesDAO;
	}

	public TipoPlatoDAO getTipoPlatoDAO() {
		return tipoPlatoDAO;
	}

	public void setTipoPlatoDAO(TipoPlatoDAO tipoPlatoDAO) {
		this.tipoPlatoDAO = tipoPlatoDAO;
	}

	public PlatosDAO getPlatosDAO() {
		return platosDAO;
	}

	public void setPlatosDAO(PlatosDAO platosDAO) {
		this.platosDAO = platosDAO;
	}
	
	



	
	
	
	

}
