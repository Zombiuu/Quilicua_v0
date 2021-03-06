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
 * Puestos generated by hbm2java
 */
@Entity
@Table(name = "PUESTOS", catalog = "quilicuabd")
public class Puestos implements java.io.Serializable {

	private Integer puestosPk;
	private String nombre;
	private String borrado;
	private Set<RelPuestosMenaje> relPuestosMenajes = new HashSet<RelPuestosMenaje>(0);
	private Set<RelPuestosMaquinaria> relPuestosMaquinarias = new HashSet<RelPuestosMaquinaria>(0);
	private Set<RelEventoPuestos> relEventoPuestoses = new HashSet<RelEventoPuestos>(0);
	private Set<RelPuestosElaboraciones> relPuestosElaboracioneses = new HashSet<RelPuestosElaboraciones>(0);

	public Puestos() {
	}

	public Puestos(String nombre, String borrado) {
		this.nombre = nombre;
		this.borrado = borrado;
	}

	public Puestos(String nombre, String borrado, Set<RelPuestosMenaje> relPuestosMenajes,
			Set<RelPuestosMaquinaria> relPuestosMaquinarias, Set<RelEventoPuestos> relEventoPuestoses,
			Set<RelPuestosElaboraciones> relPuestosElaboracioneses) {
		this.nombre = nombre;
		this.borrado = borrado;
		this.relPuestosMenajes = relPuestosMenajes;
		this.relPuestosMaquinarias = relPuestosMaquinarias;
		this.relEventoPuestoses = relEventoPuestoses;
		this.relPuestosElaboracioneses = relPuestosElaboracioneses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PUESTOS_PK", unique = true, nullable = false)
	public Integer getPuestosPk() {
		return this.puestosPk;
	}

	public void setPuestosPk(Integer puestosPk) {
		this.puestosPk = puestosPk;
	}

	@Column(name = "NOMBRE", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "BORRADO", nullable = false, length = 1)
	public String getBorrado() {
		return this.borrado;
	}

	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "puestos")
	public Set<RelPuestosMenaje> getRelPuestosMenajes() {
		return this.relPuestosMenajes;
	}

	public void setRelPuestosMenajes(Set<RelPuestosMenaje> relPuestosMenajes) {
		this.relPuestosMenajes = relPuestosMenajes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "puestos")
	public Set<RelPuestosMaquinaria> getRelPuestosMaquinarias() {
		return this.relPuestosMaquinarias;
	}

	public void setRelPuestosMaquinarias(Set<RelPuestosMaquinaria> relPuestosMaquinarias) {
		this.relPuestosMaquinarias = relPuestosMaquinarias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "puestos")
	public Set<RelEventoPuestos> getRelEventoPuestoses() {
		return this.relEventoPuestoses;
	}

	public void setRelEventoPuestoses(Set<RelEventoPuestos> relEventoPuestoses) {
		this.relEventoPuestoses = relEventoPuestoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "puestos")
	public Set<RelPuestosElaboraciones> getRelPuestosElaboracioneses() {
		return this.relPuestosElaboracioneses;
	}

	public void setRelPuestosElaboracioneses(Set<RelPuestosElaboraciones> relPuestosElaboracioneses) {
		this.relPuestosElaboracioneses = relPuestosElaboracioneses;
	}

}
