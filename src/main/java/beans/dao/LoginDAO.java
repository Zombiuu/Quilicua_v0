package beans.dao;



import org.springframework.dao.DataAccessException;

import beans.model.Login;
import beans.model.Usuarios;



public interface LoginDAO {
	
	Boolean validarUsernamePassword(Usuarios usuarios) throws DataAccessException;

}
