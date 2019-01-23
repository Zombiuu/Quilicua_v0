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
import beans.service.ElaboracionesService;

@ManagedBean(name = "elaboracionesBean")
@ViewScoped
public class ElaboracionesBean {
	private MateriasPrimasDTO materiasPrimasDTO;
	private ElaboracionesDTO elaboracionesDTO;
	private DualListModel<MateriasPrimasDTO> matPrimas;
	private Logger logger;
	private List<SelectItem> conservaciones;
	private Integer valueConservacion;
	private List<MateriasPrimasDTO> matPrimasHasta;
	List<MateriasPrimasDTO> matPrimasDesde;
	List<MateriasPrimasDTO> matPrimasSubir;
	
	@ManagedProperty(value = "#{elaboracionesService}")
	private ElaboracionesService elaboracionesService;
	FacesContext context = FacesContext.getCurrentInstance();

	public ElaboracionesBean() {
		this.materiasPrimasDTO = new MateriasPrimasDTO();
		this.elaboracionesDTO = new ElaboracionesDTO();
		this.conservaciones = new ArrayList<SelectItem>();
		matPrimasDesde = new ArrayList<MateriasPrimasDTO>();
		
		matPrimasHasta = new ArrayList<MateriasPrimasDTO>();
		matPrimasSubir = new ArrayList<MateriasPrimasDTO>();;

	}

	@PostConstruct
	public void init() {
		// MatPrimas
		
		matPrimasDesde = this.obtenerMatPrimas();
	    
		matPrimas = new DualListModel<MateriasPrimasDTO>(matPrimasDesde, matPrimasHasta);
	
		List<ConservacionesDTO> listaConservaciones = this.obtenerConservaciones();
		for (ConservacionesDTO conservacionesDTO : listaConservaciones) {
			conservaciones.add(new SelectItem(conservacionesDTO.getIdConservacion(), conservacionesDTO.getNombre()));
		}

	}

	private List<ConservacionesDTO> obtenerConservaciones() {
		List<ConservacionesDTO> listaConservaciones = null;
		try {
			listaConservaciones = this.elaboracionesService.obtenerConservaciones();
		} catch (ServiceException se) {
			listaConservaciones = new ArrayList<ConservacionesDTO>();
			logger.log(null, "Error al obtener las conservaciones");
		}
		return listaConservaciones;
	}

	private List<MateriasPrimasDTO> obtenerMatPrimas() {
		List<MateriasPrimasDTO> listaMatPrimas = null;
		try {
			listaMatPrimas = this.elaboracionesService.obtenerMatPrimas();
		} catch (ServiceException se) {
			listaMatPrimas = new ArrayList<MateriasPrimasDTO>();
			logger.log(null, "Error al obtener las materias primas");
		}
		return listaMatPrimas;
	}

	public void onTransfer(TransferEvent event) {
		
		
	        for(Object item : event.getItems()) {
	     
	        	MateriasPrimasDTO mt = new MateriasPrimasDTO();
	        	mt.setIdMatPrima(Integer.parseInt(String.valueOf(item)));
	        	
	        	matPrimasSubir.add(mt);
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
			
			
			this.elaboracionesDTO.setMateriasPrimas(matPrimasSubir);
			this.elaboracionesService.guardar(elaboracionesDTO);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					ResourceBundle.getBundle("/bundle/es_messages").getString("elaboracion.guardar.exito"), null));
		} catch (ServiceException se) {
			logger.log(null, "Error al guardar la elaboracion---->" + se.getCause());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					ResourceBundle.getBundle("/bundle/es_messages").getString("elaboracion.guardar.error"), null));
			
		}
	}

	public MateriasPrimasDTO getMateriasPrimasDTO() {
		return materiasPrimasDTO;
	}

	public void setMateriasPrimasDTO(MateriasPrimasDTO materiasPrimasDTO) {
		this.materiasPrimasDTO = materiasPrimasDTO;
	}

	public DualListModel<MateriasPrimasDTO> getMatPrimas() {
		return matPrimas;
	}

	public void setMatPrimas(DualListModel<MateriasPrimasDTO> matPrimas) {
		this.matPrimas = matPrimas;
	}

	public ElaboracionesDTO getElaboracionesDTO() {
		return elaboracionesDTO;
	}

	public void setElaboracionesDTO(ElaboracionesDTO elaboracionesDTO) {
		this.elaboracionesDTO = elaboracionesDTO;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public ElaboracionesService getElaboracionesService() {
		return elaboracionesService;
	}

	public void setElaboracionesService(ElaboracionesService elaboracionesService) {
		this.elaboracionesService = elaboracionesService;
	}

	public List<SelectItem> getConservaciones() {
		return conservaciones;
	}

	public void setConservaciones(List<SelectItem> conservaciones) {
		this.conservaciones = conservaciones;
	}

	public Integer getValueConservacion() {
		return valueConservacion;
	}

	public void setValueConservacion(Integer valueConservacion) {
		this.valueConservacion = valueConservacion;
	}

	public List<MateriasPrimasDTO> getMatPrimasHasta() {
		return matPrimasHasta;
	}

	public void setMatPrimasHasta(List<MateriasPrimasDTO> matPrimasHasta) {
		this.matPrimasHasta = matPrimasHasta;
	}

	public List<MateriasPrimasDTO> getMatPrimasDesde() {
		return matPrimasDesde;
	}

	public void setMatPrimasDesde(List<MateriasPrimasDTO> matPrimasDesde) {
		this.matPrimasDesde = matPrimasDesde;
	}
	
	
	

}