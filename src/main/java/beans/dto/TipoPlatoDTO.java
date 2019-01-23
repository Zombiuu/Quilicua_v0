package beans.dto;

import java.io.Serializable;
import java.util.List;

public class TipoPlatoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String nombre;
	
	private Integer id;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
