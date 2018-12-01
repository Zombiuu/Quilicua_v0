package beans.service;


import org.hibernate.service.spi.ServiceException;

import beans.dto.LoginDTO;

public interface GestionGlobalService {
	
	Boolean validarUsernamePassword(LoginDTO loginDTO) throws ServiceException;

}
