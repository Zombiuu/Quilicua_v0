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
 * RelPlatosMenaje generated by hbm2java
 */
@Entity
@Table(name = "REL_PLATOS_MENAJE", catalog = "quilicuabd")
public class RelPlatosMenaje implements java.io.Serializable {

	private Integer relPlatosMenajePk;
	private Menaje menaje;
	private Platos platos;
	private String borrado;
	private float cantidad;

	public RelPlatosMenaje() {
	}

	public RelPlatosMenaje(Platos platos, String borrado, float cantidad) {
		this.platos = platos;
		this.borrado = borrado;
		this.cantidad = cantidad;
	}

	public RelPlatosMenaje(Menaje menaje, Platos platos, String borrado, float cantidad) {
		this.menaje = menaje;
		this.platos = platos;
		this.borrado = borrado;
		this.cantidad = cantidad;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "REL_PLATOS_MENAJE_PK", unique = true, nullable = false)
	public Integer getRelPlatosMenajePk() {
		return this.relPlatosMenajePk;
	}

	public void setRelPlatosMenajePk(Integer relPlatosMenajePk) {
		this.relPlatosMenajePk = relPlatosMenajePk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENAJE_FK")
	public Menaje getMenaje() {
		return this.menaje;
	}

	public void setMenaje(Menaje menaje) {
		this.menaje = menaje;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLATO_FK", nullable = false)
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