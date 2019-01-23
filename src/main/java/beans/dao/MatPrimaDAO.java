package beans.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.dto.ConservacionesDTO;
import beans.dto.MateriasPrimasDTO;
import beans.model.MateriasPrimas;

public interface MatPrimaDAO{
	
	void guardar(MateriasPrimas materiasPrimas) throws DataAccessException;
	
	List<MateriasPrimasDTO> obtenerMatPrimas() throws DataAccessException;

	MateriasPrimas obtenerMateriaPrima(Integer idMatPrima) throws DataAccessException;

	

}
