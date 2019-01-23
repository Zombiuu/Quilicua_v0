package beans.dto;

import java.io.Serializable;
import java.util.List;

public class PlatosDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String nombre;
	
	private Integer tipoPlato;
	
	private List<ElaboracionesDTO> elaboraciones;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTipoPlato() {
		return tipoPlato;
	}

	public void setTipoPlato(Integer tipoPlato) {
		this.tipoPlato = tipoPlato;
	}

	public List<ElaboracionesDTO> getElaboraciones() {
		return elaboraciones;
	}

	public void setElaboraciones(List<ElaboracionesDTO> elaboraciones) {
		this.elaboraciones = elaboraciones;
	}
	
	
	

}
