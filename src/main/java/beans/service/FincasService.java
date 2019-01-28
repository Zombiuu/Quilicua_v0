package beans.service;

import org.hibernate.service.spi.ServiceException;

import beans.dto.FincasDTO;
public interface FincasService {
	
	void guardar(FincasDTO fincasDTO) throws ServiceException;
}
