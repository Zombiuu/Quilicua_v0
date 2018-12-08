package beans.model;
// default package
// Generated 08-dic-2018 17:21:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RelEventoMenaje generated by hbm2java
 */
@Entity
@Table(name = "REL_EVENTO_MENAJE", catalog = "quilicuabd")
public class RelEventoMenaje implements java.io.Serializable {

	private int relEventoMenajePk;
	private Evento evento;
	private Menaje menaje;
	private String borrado;
	private float cantidad;

	public RelEventoMenaje() {
	}

	public RelEventoMenaje(int relEventoMenajePk, Evento evento, Menaje menaje, String borrado, float cantidad) {
		this.relEventoMenajePk = relEventoMenajePk;
		this.evento = evento;
		this.menaje = menaje;
		this.borrado = borrado;
		this.cantidad = cantidad;
	}

	@Id

	@Column(name = "REL_EVENTO_MENAJE_PK", unique = true, nullable = false)
	public int getRelEventoMenajePk() {
		return this.relEventoMenajePk;
	}

	public void setRelEventoMenajePk(int relEventoMenajePk) {
		this.relEventoMenajePk = relEventoMenajePk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENTO_FK", nullable = false)
	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENAJE_FK", nullable = false)
	public Menaje getMenaje() {
		return this.menaje;
	}

	public void setMenaje(Menaje menaje) {
		this.menaje = menaje;
	}

	@Column(name = "BORRADO", nullable = false, length = 1)
	public String getBorrado() {
		return this.borrado;
	}

	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}

	@Column(name = "CANTIDAD", nullable = false, precision = 12, scale = 0)
	public float getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

}
