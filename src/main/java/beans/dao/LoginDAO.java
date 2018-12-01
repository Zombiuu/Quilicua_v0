package beans.dao;



import org.springframework.dao.DataAccessException;

import beans.model.Login;



public interface LoginDAO {
	
	Boolean validarUsernamePassword(Login login) throws DataAccessException;

}
