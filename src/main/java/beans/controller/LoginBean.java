package beans.controller;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import beans.dto.LoginDTO;
import beans.service.GestionGlobalService;
import utilities.NavigationResult;
import utilities.SessionUtils;

@Component
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

	@Autowired
	@Qualifier("gestionGlobalService")
	private GestionGlobalService gestGblService;

	private LoginDTO loginDTO;

	public LoginBean() {
		this.loginDTO = new LoginDTO();
	}

	public String comprobarLogin() {
		boolean validarLogin = false;
		try {
			validarLogin = gestGblService.validarUsernamePassword(loginDTO);
		} catch (ServiceException se) {
			se.getMessage();
		}
		String retorno = "";
		 FacesMessage mensaje = null;
		if (validarLogin) {
			
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", loginDTO.getUser());
			retorno= NavigationResult.IR_A_PAGINA_GLOBAL;
		} else {
			
			mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, ResourceBundle.getBundle("/bundle/es_messages").getString("index.login.eror.logueo"), "Usuario o contraseña erroneo.");
			retorno= NavigationResult.IR_A_PAGINA_PRINCIPAL;
		}
			
		if(mensaje!=null && !StringUtils.isEmpty(mensaje)) {
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
		}

		
		return retorno;

	}

	// evento de logout, invalida la sesión
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return NavigationResult.IR_A_PAGINA_PRINCIPAL;
	}

	public GestionGlobalService getGestGblService() {
		return gestGblService;
	}

	public void setGestGblService(GestionGlobalService gestGblService) {
		this.gestGblService = gestGblService;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

}
