package beans.model;
// default package
// Generated 08-dic-2018 17:21:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RelEventoPuestos generated by hbm2java
 */
@Entity
@Table(name = "REL_EVENTO_PUESTOS", catalog = "quilicuabd")
public class RelEventoPuestos implements java.io.Serializable {

	private Integer relEventoPuestosPk;
	private CatTurnos catTurnos;
	private Evento evento;
	private Puestos puestos;
	private int cantidad;
	private String borrado;

	public RelEventoPuestos() {
	}

	public RelEventoPuestos(CatTurnos catTurnos, Evento evento, Puestos puestos, int cantidad, String borrado) {
		this.catTurnos = catTurnos;
		this.evento = evento;
		this.puestos = puestos;
		this.cantidad = cantidad;
		this.borrado = borrado;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "REL_EVENTO_PUESTOS_PK", unique = true, nullable = false)
	public Integer getRelEventoPuestosPk() {
		return this.relEventoPuestosPk;
	}

	public void setRelEventoPuestosPk(Integer relEventoPuestosPk) {
		this.relEventoPuestosPk = relEventoPuestosPk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TURNO", nullable = false)
	public CatTurnos getCatTurnos() {
		return this.catTurnos;
	}

	public void setCatTurnos(CatTurnos catTurnos) {
		this.catTurnos = catTurnos;
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
	@JoinColumn(name = "PUESTOS_FK", nullable = false)
	public Puestos getPuestos() {
		return this.puestos;
	}

	public void setPuestos(Puestos puestos) {
		this.puestos = puestos;
	}

	@Column(name = "CANTIDAD", nullable = false)
	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "BORRADO", nullable = false, length = 1)
	public String getBorrado() {
		return this.borrado;
	}

	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}

}
