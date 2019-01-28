package beans.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.dto.ElaboracionesDTO;
import beans.dto.MenajeDTO;
import beans.model.Elaboraciones;
import beans.model.Menaje;

public interface MenajeDAO {
	
	Menaje guardar(Menaje menaje) throws DataAccessException;

	List<MenajeDTO> obtenerMenajes() throws DataAccessException;

	Menaje obtenerMenaje(Integer idMenaje) throws DataAccessException;

}
