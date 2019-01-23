package beans.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.dto.TipoPlatoDTO;
import beans.model.CatTipoPlato;

public interface TipoPlatoDAO{



	List<TipoPlatoDTO> obtenerListaTipoPlato() throws DataAccessException;

	CatTipoPlato obtenerTipoPlato(Integer tipoPlato) throws DataAccessException;
	
	
	

}
