package beans.service;

import java.util.ArrayList;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import beans.dao.EventoDAO;
import beans.dto.EventoDTO;


@Service("eventoService")
@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = {ServiceException.class, RuntimeException.class})
public class EventoServiceImpl implements EventoService{
	
	@Autowired
	@Qualifier("eventoDAO")
	private EventoDAO eventoDAO;

	@Override
	public ArrayList<EventoDTO> obtenerEventos() throws ServiceException {
		ArrayList<EventoDTO> arrEventosDTO = null;
		try {
			arrEventosDTO=this.eventoDAO.getTotalResult();
			if(arrEventosDTO==null) {
				arrEventosDTO = new ArrayList<EventoDTO>();
			}
		}catch(ServiceException se) {
			throw new ServiceException(se.getMessage());
		}
	
		return arrEventosDTO;
	}

	public EventoDAO getEventoDAO() {
		return eventoDAO;
	}

	public void setEventoDAO(EventoDAO eventoDAO) {
		this.eventoDAO = eventoDAO;
	}
	
	

}
