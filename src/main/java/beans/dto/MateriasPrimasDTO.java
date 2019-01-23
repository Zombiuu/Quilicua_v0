package beans.dto;

import java.io.Serializable;

public class MateriasPrimasDTO implements Serializable{
	
	private Integer idMatPrima;
	
	private String nombre;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdMatPrima() {
		return idMatPrima;
	}

	public void setIdMatPrima(Integer idMatPrima) {
		this.idMatPrima = idMatPrima;
	}
	
	
	
	

}
