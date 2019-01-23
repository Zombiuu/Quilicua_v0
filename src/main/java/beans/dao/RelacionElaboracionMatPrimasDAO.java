package beans.dao;

import org.springframework.dao.DataAccessException;

import beans.model.RelElaboracionesMateriasPrimas;



public interface RelacionElaboracionMatPrimasDAO {
	
	void guardar(RelElaboracionesMateriasPrimas rel) throws DataAccessException;

}
