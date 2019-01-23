package beans.dto;

import java.io.Serializable;

public class ConservacionesDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idConservacion;
	private String nombre;
	public Integer getIdConservacion() {
		return idConservacion;
	}
	public void setIdConservacion(Integer idConservacion) {
		this.idConservacion = idConservacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
