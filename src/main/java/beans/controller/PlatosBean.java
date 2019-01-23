package beans.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.service.spi.ServiceException;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;


import beans.dto.ConservacionesDTO;
import beans.dto.ElaboracionesDTO;
import beans.dto.MateriasPrimasDTO;
import beans.dto.PlatosDTO;
import beans.dto.TipoPlatoDTO;
import beans.service.ElaboracionesService;
import beans.service.PlatosService;

@ManagedBean(name = "platosBean")
@ViewScoped
public class PlatosBean {
	
	private PlatosDTO platosDTO;
	private DualListModel<ElaboracionesDTO> elaboraciones;
	private Logger logger;
	private List<SelectItem> tipoPlatos;
	private Integer valueTipoPlatos;
	private List<ElaboracionesDTO> elaboracionesHasta;
	List<ElaboracionesDTO> elaboracionesDesde;
	List<ElaboracionesDTO> elaboracionesSubir;
	
	@ManagedProperty(value = "#{platosService}")
	private PlatosService platosService;
	FacesContext context = FacesContext.getCurrentInstance();

	public PlatosBean() {
		this.platosDTO = new PlatosDTO();
		this.tipoPlatos = new ArrayList<SelectItem>();
		elaboracionesDesde = new ArrayList<ElaboracionesDTO>();
		
		elaboracionesHasta = new ArrayList<ElaboracionesDTO>();
		elaboracionesSubir = new ArrayList<ElaboracionesDTO>();;

	}

	@PostConstruct
	public void init() {
	
		elaboracionesDesde = this.obtenerElaboraciones();
	    
		elaboraciones = new DualListModel<ElaboracionesDTO>(elaboracionesDesde, elaboracionesHasta);
	
		List<TipoPlatoDTO> listaTipoPlato = this.obtenerTipoPlato();
		for (TipoPlatoDTO tipoPlatoDTO : listaTipoPlato) {
			tipoPlatos.add(new SelectItem(tipoPlatoDTO.getId(), tipoPlatoDTO.getNombre()));
		}

	}

	private List<TipoPlatoDTO> obtenerTipoPlato() {
		List<TipoPlatoDTO> listaTipoPlato = null;
		try {
			listaTipoPlato = this.platosService.obtenerTipoPlato();
		} catch (ServiceException se) {
			listaTipoPlato = new ArrayList<TipoPlatoDTO>();
			logger.log(null, "Error al obtener tipo plato");
		}
		return listaTipoPlato;
	}

	private List<ElaboracionesDTO> obtenerElaboraciones() {
		List<ElaboracionesDTO> listaElaboraciones = null;
		try {
			listaElaboraciones = this.platosService.obtenerElaboraciones();
		} catch (ServiceException se) {
			listaElaboraciones = new ArrayList<ElaboracionesDTO>();
			logger.log(null, "Error al obtener las elaboracioness");
		}
		return listaElaboraciones;
	}

	public void onTransfer(TransferEvent event) {
		
		
	        for(Object item : event.getItems()) {
	     
	        	ElaboracionesDTO el = new ElaboracionesDTO();
	        	el.setId((Integer.parseInt(String.valueOf(item))));
	        	
	        	elaboracionesSubir.add(el);
	        }
//		FacesMessage msg = new FacesMessage();
//		msg.setSeverity(FacesMessage.SEVERITY_INFO);
//		msg.setSummary("Materia prima añadida");
//	
//	
//	
//
//		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onSelect(SelectEvent event) {

//		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
//				ResourceBundle.getBundle("/bundle/es_messages").getString("elaboracion.matprima.seleccionada"), null));
	}

	public void onUnselect(UnselectEvent event) {
	
//		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
//				ResourceBundle.getBundle("/bundle/es_messages").getString("elaboracion.matprima.deseleccionada"), null));
	}

	public void onReorder() {
		
//		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
//				ResourceBundle.getBundle("/bundle/es_messages").getString("elaboracion.matprima.reordenada"), null));
	}
	
	
	
	public void guardar() {
		try {
			
			
			this.platosDTO.setElaboraciones(elaboracionesSubir);
			this.platosService.guardar(platosDTO);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					ResourceBundle.getBundle("/bundle/es_messages").getString("platos.guardar.exito"), null));
		} catch (ServiceException se) {
			logger.log(null, "Error al guardar la elaboracion---->" + se.getCause());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					ResourceBundle.getBundle("/bundle/es_messages").getString("platos.guardar.error"), null));
			
		}
	}

	public PlatosDTO getPlatosDTO() {
		return platosDTO;
	}

	public void setPlatosDTO(PlatosDTO platosDTO) {
		this.platosDTO = platosDTO;
	}

	public DualListModel<ElaboracionesDTO> getElaboraciones() {
		return elaboraciones;
	}

	public void setElaboraciones(DualListModel<ElaboracionesDTO> elaboraciones) {
		this.elaboraciones = elaboraciones;
	}

	public List<SelectItem> getTipoPlatos() {
		return tipoPlatos;
	}

	public void setTipoPlatos(List<SelectItem> tipoPlatos) {
		this.tipoPlatos = tipoPlatos;
	}

	public Integer getValueTipoPlatos() {
		return valueTipoPlatos;
	}

	public void setValueTipoPlatos(Integer valueTipoPlatos) {
		this.valueTipoPlatos = valueTipoPlatos;
	}

	public List<ElaboracionesDTO> getElaboracionesHasta() {
		return elaboracionesHasta;
	}

	public void setElaboracionesHasta(List<ElaboracionesDTO> elaboracionesHasta) {
		this.elaboracionesHasta = elaboracionesHasta;
	}

	public List<ElaboracionesDTO> getElaboracionesDesde() {
		return elaboracionesDesde;
	}

	public void setElaboracionesDesde(List<ElaboracionesDTO> elaboracionesDesde) {
		this.elaboracionesDesde = elaboracionesDesde;
	}

	public List<ElaboracionesDTO> getElaboracionesSubir() {
		return elaboracionesSubir;
	}

	public void setElaboracionesSubir(List<ElaboracionesDTO> elaboracionesSubir) {
		this.elaboracionesSubir = elaboracionesSubir;
	}

	public PlatosService getPlatosService() {
		return platosService;
	}

	public void setPlatosService(PlatosService platosService) {
		this.platosService = platosService;
	}

	

	
	
	
	
	

}