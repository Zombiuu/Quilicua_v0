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
 * RelPlatosElaboraciones generated by hbm2java
 */
@Entity
@Table(name = "REL_PLATOS_ELABORACIONES", catalog = "quilicuabd")
public class RelPlatosElaboraciones implements java.io.Serializable {

	private Integer relPlatosElaboracionesPk;
	private Elaboraciones elaboraciones;
	private Platos platos;
	private String borrado;
	private float cantidad;

	public RelPlatosElaboraciones() {
	}

	public RelPlatosElaboraciones(Elaboraciones elaboraciones, Platos platos, String borrado, float cantidad) {
		this.elaboraciones = elaboraciones;
		this.platos = platos;
		this.borrado = borrado;
		this.cantidad = cantidad;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "REL_PLATOS_ELABORACIONES_PK", unique = true, nullable = false)
	public Integer getRelPlatosElaboracionesPk() {
		return this.relPlatosElaboracionesPk;
	}

	public void setRelPlatosElaboracionesPk(Integer relPlatosElaboracionesPk) {
		this.relPlatosElaboracionesPk = relPlatosElaboracionesPk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ELABORACIONES_FK", nullable = false)
	public Elaboraciones getElaboraciones() {
		return this.elaboraciones;
	}

	public void setElaboraciones(Elaboraciones elaboraciones) {
		this.elaboraciones = elaboraciones;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLATOS_FK", nullable = false)
	public Platos getPlatos() {
		return this.platos;
	}

	public void setPlatos(Platos platos) {
		this.platos = platos;
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
