package beans.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import beans.dto.EventoDTO;
import beans.model.Evento;

public interface EventoDAO {
	void persist(Evento transientInstance);
	void attachDirty(Evento instance);
	void attachClean(Evento instance);
	void delete(Evento persistentInstance);
	Evento merge(Evento detachedInstance);
	Evento findById(java.lang.Integer id);
	List findByExample(Evento instance);
	ArrayList<EventoDTO> getTotalResult() throws DataAccessException;
	

}
