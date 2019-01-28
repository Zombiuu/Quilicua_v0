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


import beans.dao.MenajeDAO;
import beans.dao.TipoMenajeDAO;

import beans.dto.MenajeDTO;
import beans.dto.TipoMenajeDTO;
import beans.model.Menaje;



@Service("menajeService")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { ServiceException.class,
		RuntimeException.class })
public class MenajeServiceImpl implements MenajeService {

	@Autowired
	@Qualifier("tipoMenajeDAO")
	private TipoMenajeDAO tipoMenajeDAO;

	@Autowired
	@Qualifier("menajeDAO")
	private MenajeDAO menajeDAO;
	
	
	


	@Override
	public List<TipoMenajeDTO> obtenerTiposMenaje() throws ServiceException {
		List<TipoMenajeDTO> listaTiposMenaje = new ArrayList<TipoMenajeDTO>();
		try {
			listaTiposMenaje = this.tipoMenajeDAO.obtenerTiposMenaje();
		} catch (ServiceException se) {
			throw new ServiceException(se.getMessage());
		}
		return listaTiposMenaje;
	}



	@Override
	public void guardar(MenajeDTO menajeDTO) throws ServiceException {
		try {
			Menaje menaje = this.mapearDTOaEntidad(menajeDTO);
			this.menajeDAO.guardar(menaje);
			
		} catch (ServiceException se) {
			throw new ServiceException(se.getMessage());
		}

	}

	private Menaje mapearDTOaEntidad(MenajeDTO menajeDTO) throws ServiceException {
		
		Menaje menaje = new Menaje();
		menaje.setNombre(menajeDTO.getNombre());
		
		
		try {
			menaje.setTipoMenaje(this.tipoMenajeDAO.obtenerTipoMenaje(menajeDTO.getValueTiposMenaje()));
				
		} catch (ServiceException se) {
			throw new ServiceException(se.getMessage());
		}

		menaje.setBorrado("N");

	
		

		return menaje;

	}



	public TipoMenajeDAO getTiposMenajeDAO() {
		return tipoMenajeDAO;
	}



	public void setTiposMenajeDAO(TipoMenajeDAO tiposMenajeDAO) {
		this.tipoMenajeDAO = tiposMenajeDAO;
	}



	public MenajeDAO getMenajeDAO() {
		return menajeDAO;
	}



	public void setMenajeDAO(MenajeDAO menajeDAO) {
		this.menajeDAO = menajeDAO;
	}
	
	
		
		
		
	}


