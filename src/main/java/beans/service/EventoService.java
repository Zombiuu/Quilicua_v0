package beans.service;

import java.util.ArrayList;

import org.hibernate.service.spi.ServiceException;

import beans.dto.EventoDTO;



public interface EventoService {
	
	ArrayList<EventoDTO> obtenerEventos() throws ServiceException;

}
