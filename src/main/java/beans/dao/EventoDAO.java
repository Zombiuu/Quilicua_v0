package beans.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.dto.EventoDTO;
import beans.model.Evento;

public interface EventoDAO {
	
	ArrayList<EventoDTO> getTotalResult() throws DataAccessException;
	

}
