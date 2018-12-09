package beans.service;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.dao.MatPrimaDAO;
import beans.dto.MatPrimasDTO;
import beans.model.MateriasPrimas;

@Service("gh")
@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = {ServiceException.class, RuntimeException.class})
public class MatPrimasServiceImpl implements MatPrimasService{
	
	@Autowired
	@Qualifier("matPrimaDAO")
	private MatPrimaDAO matPrimaDAO;

	@Override
	public void guardar(MatPrimasDTO matPrimasDTO) throws ServiceException {
		try {
			
			this.matPrimaDAO.guardar(this.mapearDTOaEntidad(matPrimasDTO));
		}catch(ServiceException se) {
			throw new ServiceException(se.getMessage());
		}
		
	}
	
	private MateriasPrimas mapearDTOaEntidad(MatPrimasDTO matPrimasDTO) {
		MateriasPrimas materiasPrimas = new MateriasPrimas();
		materiasPrimas.setNombre(matPrimasDTO.getNombre());
		materiasPrimas.setBorrado("N");
		return materiasPrimas;
		
	}

	public MatPrimaDAO getMatPrimaDAO() {
		return matPrimaDAO;
	}

	public void setMatPrimaDAO(MatPrimaDAO matPrimaDAO) {
		this.matPrimaDAO = matPrimaDAO;
	}
	
	

}
