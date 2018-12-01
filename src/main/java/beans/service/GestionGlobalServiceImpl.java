package beans.service;



import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.dao.LoginDAO;
import beans.dto.LoginDTO;
import beans.model.Login;

@Service("gestionGlobalService")
@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = {ServiceException.class, RuntimeException.class})
public class GestionGlobalServiceImpl implements GestionGlobalService {
	
	@Autowired
	@Qualifier("loginDAO")
	private LoginDAO loginDAO;

	@Override
	public Boolean validarUsernamePassword(LoginDTO loginDTO) throws ServiceException {
		boolean validarLogin = false;
		try {
			Login login = this.mapearDTOaEntidad(loginDTO);
			validarLogin = this.loginDAO.validarUsernamePassword(login);
		}catch(ServiceException se) {
			se.getMessage();
		}
		return validarLogin;
	}

	private Login mapearDTOaEntidad(LoginDTO loginDTO) {
		Login login = new Login();
		login.setUname(loginDTO.getUser());
		login.setPassword(loginDTO.getPass());
		return login;
	}

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	

}
