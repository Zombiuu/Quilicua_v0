package beans.dao;

import org.springframework.dao.DataAccessException;

import beans.model.MateriasPrimas;

public interface MatPrimaDAO{
	
	void guardar(MateriasPrimas materiasPrimas) throws DataAccessException;

}
