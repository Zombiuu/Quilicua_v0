package beans.service;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.dao.FincasDAO;
import beans.dto.FincasDTO;
import beans.model.Fincas;


@Service("fincasService")
@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = {ServiceException.class, RuntimeException.class})
public class FincasServiceImpl implements FincasService{
	
	@Autowired
	@Qualifier("fincasDAO")
	private FincasDAO fincasDAO;

	@Override
	public void guardar(FincasDTO fincasDTO) throws ServiceException {
		try {
			
			this.fincasDAO.guardar(this.mapearDTOaEntidad(fincasDTO));
		}catch(ServiceException se) {
			throw new ServiceException(se.getMessage());
		}
		
	}
	
	private Fincas mapearDTOaEntidad(FincasDTO fincasDTO) {
		Fincas fincas = new Fincas();
		fincas.setNombre(fincasDTO.getNombre());
		fincas.setDireccion(fincasDTO.getDireccion());
		fincas.setBorrado("N");
		return fincas;
		
	}

	public FincasDAO getFincasDAO() {
		return fincasDAO;
	}

	public void setFincasDAO(FincasDAO fincasDAO) {
		this.fincasDAO = fincasDAO;
	}

	
	
	

}
