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
import beans.model.Usuarios;

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
			Usuarios usuarios = this.mapearDTOaEntidad(loginDTO);
			validarLogin = this.loginDAO.validarUsernamePassword(usuarios);
		}catch(ServiceException se) {
			se.getMessage();
		}
		return validarLogin;
	}

	private Usuarios mapearDTOaEntidad(LoginDTO loginDTO) {
		Usuarios usuarios = new Usuarios();
		usuarios.setNombre(loginDTO.getUser());
		usuarios.setPassword(loginDTO.getPass());

		
		
		return usuarios;
	}

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	

}
