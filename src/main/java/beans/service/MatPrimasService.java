package beans.service;

import org.hibernate.service.spi.ServiceException;

import beans.dto.MatPrimasDTO;

public interface MatPrimasService {
	
	void guardar(MatPrimasDTO matPrimasDTO) throws ServiceException;
}
