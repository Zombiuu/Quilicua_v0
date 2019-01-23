package beans.dao;

import org.springframework.dao.DataAccessException;


import beans.model.Elaboraciones;
import beans.model.Platos;

public interface PlatosDAO {
	
	Platos guardar(Platos platos) throws DataAccessException;

}
