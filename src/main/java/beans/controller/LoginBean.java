package beans.controller;

import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.ServiceException;
import org.springframework.util.StringUtils;

import beans.dto.LoginDTO;
import beans.service.GestionGlobalService;
import utilities.NavigationResult;
import utilities.SessionUtils;


@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

	
	@ManagedProperty(value= "#{gestionGlobalService}")
	private GestionGlobalService gestGblService;

	private LoginDTO loginDTO;

	public LoginBean() {
		this.loginDTO = new LoginDTO();
	}
	
	/**
	 * En este init se comprueba si hay sesión iniciado.
	 * Si la hay entonces, navega directamente al global.xhtml y si no
	 * te devuelve al login.xhtml
	 */
	@PostConstruct
	public String init() {
		if(SessionUtils.getSession()!=null) {
			return this.paginar(true);
		}else {
			return this.paginar(false);
		}
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
			retorno=this.paginar(true);
		} else {
			retorno=this.paginar(false);
			mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, ResourceBundle.getBundle("/bundle/es_messages").getString("index.login.eror.logueo"), "Usuario o contraseña erroneo.");
			
		}
			
		if(mensaje!=null && !StringUtils.isEmpty(mensaje)) {
			FacesContext.getCurrentInstance().addMessage(null, mensaje);
		}

		
		return retorno;

	}
	
	/**
	 * metodo para entrar desde el login al global.xhtml o viceversa.
	 */
	private String paginar(boolean esValidada) {
		if(esValidada) {
			return NavigationResult.IR_A_PAGINA_GLOBAL;
		}else{
			return NavigationResult.IR_A_PAGINA_PRINCIPAL;
		}
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
