package beans.controller;

import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.hibernate.service.spi.ServiceException;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import beans.dto.MatPrimasDTO;
import beans.service.MatPrimasService;

@ManagedBean(name = "matPrimasBean")
@SessionScope
public class MatPrimasBean {
	private MatPrimasDTO matPrimasDTO;
	private Logger logger;
	@ManagedProperty(value = "#{gh}")
	private MatPrimasService matPrimasService;

	public MatPrimasBean() {
		this.matPrimasDTO = new MatPrimasDTO();
	}

	public void guardar() {

		try {
			this.matPrimasService.guardar(matPrimasDTO);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					ResourceBundle.getBundle("/bundle/es_messages").getString("matprimas.guardar.exito"), null));
		} catch (ServiceException se) {
			logger.log(null, "Se ha producido un error al guardar la entidad MateriasPrimas");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					ResourceBundle.getBundle("/bundle/es_messages").getString("matprimas.guardar.error"), null));

		}

	}

	public MatPrimasDTO getMatPrimasDTO() {
		return matPrimasDTO;
	}

	public void setMatPrimasDTO(MatPrimasDTO matPrimasDTO) {
		this.matPrimasDTO = matPrimasDTO;
	}

	public MatPrimasService getMatPrimasService() {
		return matPrimasService;
	}

	public void setMatPrimasService(MatPrimasService matPrimasService) {
		this.matPrimasService = matPrimasService;
	}
	
	

}
