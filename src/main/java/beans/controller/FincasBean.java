package beans.controller;

import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.hibernate.service.spi.ServiceException;
import org.springframework.web.context.annotation.SessionScope;

import beans.dto.FincasDTO;
import beans.service.FincasService;

@ManagedBean(name = "fincasBean")
@SessionScope
public class FincasBean {
	private FincasDTO fincasDTO;
	private Logger logger;
	@ManagedProperty(value = "#{fincasService}")
	private FincasService fincasService;

	public FincasBean() {
		this.fincasDTO = new FincasDTO();
	}

	public void guardar() {

		try {
			this.fincasService.guardar(fincasDTO);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					ResourceBundle.getBundle("/bundle/es_messages").getString("fincas.guardar.exito"), null));
		} catch (ServiceException se) {
			logger.log(null, "Se ha producido un error al guardar la entidad Ubicaciones");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					ResourceBundle.getBundle("/bundle/es_messages").getString("fincas.guardar.error"), null));

		}

	}

	public FincasDTO getFincasDTO() {
		return fincasDTO;
	}

	public void setFincasDTO(FincasDTO fincasDTO) {
		this.fincasDTO = fincasDTO;
	}

	public FincasService getFincasService() {
		return fincasService;
	}

	public void setFincasService(FincasService fincasService) {
		this.fincasService = fincasService;
	}

	
	
	

}
