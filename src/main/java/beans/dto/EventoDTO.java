package beans.dto;

import java.io.Serializable;
import java.util.Date;

public class EventoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer eventoPk;
	private String nombre;
	private String borrado;
	private Date fechaAlta;
	private Date fechaBaja;
	private Integer usuarioFk;
	private Integer comensales;
	private String observaciones;
	private String encargado;
	private Integer recenaFk;
	private Integer coctelFk;
	private Integer banqueteFk;
	
	public Integer getEventoPk() {
		return eventoPk;
	}
	public void setEventoPk(Integer eventoPk) {
		this.eventoPk = eventoPk;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getBorrado() {
		return borrado;
	}
	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public Integer getUsuarioFk() {
		return usuarioFk;
	}
	public void setUsuarioFk(Integer usuarioFk) {
		this.usuarioFk = usuarioFk;
	}
	
	public Integer getComensales() {
		return comensales;
	}
	public void setComensales(Integer comensales) {
		this.comensales = comensales;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getEncargado() {
		return encargado;
	}
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	public Integer getRecenaFk() {
		return recenaFk;
	}
	public void setRecenaFk(Integer recenaFk) {
		this.recenaFk = recenaFk;
	}
	public Integer getCoctelFk() {
		return coctelFk;
	}
	public void setCoctelFk(Integer coctelFk) {
		this.coctelFk = coctelFk;
	}
	public Integer getBanqueteFk() {
		return banqueteFk;
	}
	public void setBanqueteFk(Integer banqueteFk) {
		this.banqueteFk = banqueteFk;
	}
	
	

}
