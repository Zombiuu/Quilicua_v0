package beans.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.dto.FincasDTO;
import beans.model.Fincas;


public interface FincasDAO{
	
	void guardar(Fincas fincas) throws DataAccessException;
	
	List<FincasDTO> obtenerFincas() throws DataAccessException;

	Fincas obtenerFinca(Integer idFincas) throws DataAccessException;

	

}
