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
import beans.dto.MenajeDTO;
import beans.dto.TipoMenajeDTO;
import beans.service.ElaboracionesService;
import beans.service.MenajeService;

@ManagedBean(name = "menajeBean")
@ViewScoped
public class MenajeBean {
	
	private MenajeDTO menajeDTO;
	private Logger logger;
	private List<SelectItem> tipoMenaje;
	private Integer valueTipoMenaje;
	
	@ManagedProperty(value = "#{menajeService}")
	private MenajeService menajeService;
	FacesContext context = FacesContext.getCurrentInstance();

	public MenajeBean() {
		
		this.menajeDTO = new MenajeDTO();
		this.tipoMenaje = new ArrayList<SelectItem>();

	}

	@PostConstruct
	public void init() {
				
		List<TipoMenajeDTO> listaTiposMenaje = this.obtenerTiposMenaje();
		for (TipoMenajeDTO tiposMenajeDTO : listaTiposMenaje) {
			tipoMenaje.add(new SelectItem(tiposMenajeDTO.getIdTipoMenaje(), tiposMenajeDTO.getNombre()));
		}

	}

	private List<TipoMenajeDTO> obtenerTiposMenaje() {
		List<TipoMenajeDTO> listaTiposMenaje = null;
		try {
			listaTiposMenaje = this.menajeService.obtenerTiposMenaje();
		} catch (ServiceException se) {
			listaTiposMenaje = new ArrayList<TipoMenajeDTO>();
			logger.log(null, "Error al obtener las conservaciones");
		}
		return listaTiposMenaje;
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
		
			this.menajeService.guardar(menajeDTO);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					ResourceBundle.getBundle("/bundle/es_messages").getString("menaje.guardar.exito"), null));
		} catch (ServiceException se) {
			logger.log(null, "Error al guardar la elaboracion---->" + se.getCause());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					ResourceBundle.getBundle("/bundle/es_messages").getString("menaje.guardar.error"), null));
			
		}
	}

	public MenajeDTO getMenajeDTO() {
		return menajeDTO;
	}

	public void setMenajeDTO(MenajeDTO menajeDTO) {
		this.menajeDTO = menajeDTO;
	}

	public List<SelectItem> getTipoMenaje() {
		return tipoMenaje;
	}

	public void setTipoMenaje(List<SelectItem> tipoMenaje) {
		this.tipoMenaje = tipoMenaje;
	}

	public Integer getValueTipoMenaje() {
		return valueTipoMenaje;
	}

	public void setValueTipoMenaje(Integer valueTipoMenaje) {
		this.valueTipoMenaje = valueTipoMenaje;
	}

	public MenajeService getMenajeService() {
		return menajeService;
	}

	public void setMenajeService(MenajeService menajeService) {
		this.menajeService = menajeService;
	}


	
	

}