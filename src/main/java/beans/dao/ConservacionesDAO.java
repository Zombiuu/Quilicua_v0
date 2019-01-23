package beans.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.dto.ConservacionesDTO;
import beans.model.CatConservaciones;

public interface ConservacionesDAO {
	List<ConservacionesDTO> obtenerConservaciones() throws DataAccessException;

	CatConservaciones obtenerConservacion(Integer valueConservacion) throws DataAccessException;
}
