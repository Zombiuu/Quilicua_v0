package beans.model;
// default package
// Generated 08-dic-2018 17:21:26 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Menaje generated by hbm2java
 */
@Entity
@Table(name = "MENAJE", catalog = "quilicuabd")
public class Menaje implements java.io.Serializable {

	private Integer menajePk;
	private String nombre;
	private String borrado;
	private Set<RelPuestosMenaje> relPuestosMenajes = new HashSet<RelPuestosMenaje>(0);
	private Set<RelPlatosMenaje> relPlatosMenajes = new HashSet<RelPlatosMenaje>(0);
	private Set<RelEventoMenaje> relEventoMenajes = new HashSet<RelEventoMenaje>(0);

	public Menaje() {
	}

	public Menaje(String nombre, String borrado) {
		this.nombre = nombre;
		this.borrado = borrado;
	}

	public Menaje(String nombre, String borrado, Set<RelPuestosMenaje> relPuestosMenajes,
			Set<RelPlatosMenaje> relPlatosMenajes, Set<RelEventoMenaje> relEventoMenajes) {
		this.nombre = nombre;
		this.borrado = borrado;
		this.relPuestosMenajes = relPuestosMenajes;
		this.relPlatosMenajes = relPlatosMenajes;
		this.relEventoMenajes = relEventoMenajes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MENAJE_PK", unique = true, nullable = false)
	public Integer getMenajePk() {
		return this.menajePk;
	}

	public void setMenajePk(Integer menajePk) {
		this.menajePk = menajePk;
	}

	@Column(name = "NOMBRE", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "BORRADO", nullable = false, length = 45)
	public String getBorrado() {
		return this.borrado;
	}

	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menaje")
	public Set<RelPuestosMenaje> getRelPuestosMenajes() {
		return this.relPuestosMenajes;
	}

	public void setRelPuestosMenajes(Set<RelPuestosMenaje> relPuestosMenajes) {
		this.relPuestosMenajes = relPuestosMenajes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menaje")
	public Set<RelPlatosMenaje> getRelPlatosMenajes() {
		return this.relPlatosMenajes;
	}

	public void setRelPlatosMenajes(Set<RelPlatosMenaje> relPlatosMenajes) {
		this.relPlatosMenajes = relPlatosMenajes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menaje")
	public Set<RelEventoMenaje> getRelEventoMenajes() {
		return this.relEventoMenajes;
	}

	public void setRelEventoMenajes(Set<RelEventoMenaje> relEventoMenajes) {
		this.relEventoMenajes = relEventoMenajes;
	}

}