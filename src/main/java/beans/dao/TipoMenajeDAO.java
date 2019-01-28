package beans.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.dto.TipoMenajeDTO;
import beans.model.CatTipoMenaje;

public interface TipoMenajeDAO {
	
	List<TipoMenajeDTO> obtenerTiposMenaje() throws DataAccessException;

	CatTipoMenaje obtenerTipoMenaje(Integer valueConservacion) throws DataAccessException;
}
