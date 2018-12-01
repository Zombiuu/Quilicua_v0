package beans.controller;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import beans.dto.EventoDTO;
import beans.service.EventoService;


@Component
@ManagedBean(name = "globalBean")
@RequestScoped
public class GlobalBean {
	private EventoDTO eventoDTO;
	private Logger logger;
	private ArrayList<EventoDTO> arrEventoDTO;
	@Autowired
	@Qualifier("eventoService")
	private EventoService eventoService;

	public GlobalBean() {

		this.eventoDTO = new EventoDTO();
	}
	
	@PostConstruct
	public void init() {
		this.recuperarListaEventos();
	}

	public void recuperarListaEventos() {
		try {
			arrEventoDTO=this.eventoService.obtenerEventos();
			if(arrEventoDTO==null) {
				arrEventoDTO= new ArrayList<EventoDTO>();			}
		}catch(ServiceException se) {
			logger.log(null, "Error al obtener los eventos");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ResourceBundle.getBundle("/bundle/es_messages").getString("global.obtener.total.eventos"), null));
		}
		
		
	}

	public EventoDTO getEventoDTO() {
		return eventoDTO;
	}

	public void setEventoDTO(EventoDTO eventoDTO) {
		this.eventoDTO = eventoDTO;
	}

	public ArrayList<EventoDTO> getArrEventoDTO() {
		return arrEventoDTO;
	}

	public void setArrEventoDTO(ArrayList<EventoDTO> arrEventoDTO) {
		this.arrEventoDTO = arrEventoDTO;
	}

	public EventoService getEventoService() {
		return eventoService;
	}

	public void setEventoService(EventoService eventoService) {
		this.eventoService = eventoService;
	}
	
	

}
