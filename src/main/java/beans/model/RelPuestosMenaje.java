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
 * RelPuestosMenaje generated by hbm2java
 */
@Entity
@Table(name = "REL_PUESTOS_MENAJE", catalog = "quilicuabd")
public class RelPuestosMenaje implements java.io.Serializable {

	private Integer relPuestosMenajePk;
	private Menaje menaje;
	private Puestos puestos;
	private String borrado;

	public RelPuestosMenaje() {
	}

	public RelPuestosMenaje(Menaje menaje, Puestos puestos, String borrado) {
		this.menaje = menaje;
		this.puestos = puestos;
		this.borrado = borrado;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "REL_PUESTOS_MENAJE_PK", unique = true, nullable = false)
	public Integer getRelPuestosMenajePk() {
		return this.relPuestosMenajePk;
	}

	public void setRelPuestosMenajePk(Integer relPuestosMenajePk) {
		this.relPuestosMenajePk = relPuestosMenajePk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENAJE_FK", nullable = false)
	public Menaje getMenaje() {
		return this.menaje;
	}

	public void setMenaje(Menaje menaje) {
		this.menaje = menaje;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PUESTOS_FK", nullable = false)
	public Puestos getPuestos() {
		return this.puestos;
	}

	public void setPuestos(Puestos puestos) {
		this.puestos = puestos;
	}

	@Column(name = "BORRADO", nullable = false, length = 1)
	public String getBorrado() {
		return this.borrado;
	}

	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}

}