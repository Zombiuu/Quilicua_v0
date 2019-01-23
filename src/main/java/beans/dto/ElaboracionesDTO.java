package beans.dto;

import java.io.Serializable;
import java.util.List;

public class ElaboracionesDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String nombre;
	
	private Integer valueConservacion;
	
	private List<MateriasPrimasDTO> materiasPrimas;
	
	private Integer id;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getValueConservacion() {
		return valueConservacion;
	}

	public void setValueConservacion(Integer valueConservacion) {
		this.valueConservacion = valueConservacion;
	}

	public List<MateriasPrimasDTO> getMateriasPrimas() {
		return materiasPrimas;
	}

	public void setMateriasPrimas(List<MateriasPrimasDTO> materiasPrimas) {
		this.materiasPrimas = materiasPrimas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
