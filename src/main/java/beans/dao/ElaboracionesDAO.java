package beans.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.dto.ElaboracionesDTO;
import beans.model.Elaboraciones;

public interface ElaboracionesDAO {
	
	Elaboraciones guardar(Elaboraciones elaboracion) throws DataAccessException;

	List<ElaboracionesDTO> obtenerElaboraciones() throws DataAccessException;

	Elaboraciones obtenerElaboracion(Integer idELaboracion) throws DataAccessException;

}
