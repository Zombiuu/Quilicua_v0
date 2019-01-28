package beans.dto;

import java.io.Serializable;
import java.util.List;

public class MenajeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
	private Integer valueTiposMenaje;
	
	private Integer id;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getValueTiposMenaje() {
		return valueTiposMenaje;
	}

	public void setValueTiposMenaje(Integer valueTiposMenaje) {
		this.valueTiposMenaje = valueTiposMenaje;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
