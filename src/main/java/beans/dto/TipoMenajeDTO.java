package beans.dto;

import java.io.Serializable;

public class TipoMenajeDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTipoMenaje;
	private String nombre;
	public Integer getIdTipoMenaje() {
		return idTipoMenaje;
	}
	public void setIdTipoMenaje(Integer idTipoMenaje) {
		this.idTipoMenaje = idTipoMenaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
