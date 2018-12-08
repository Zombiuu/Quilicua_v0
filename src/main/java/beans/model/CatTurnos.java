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
 * CatTurnos generated by hbm2java
 */
@Entity
@Table(name = "CAT_TURNOS", catalog = "quilicuabd")
public class CatTurnos implements java.io.Serializable {

	private Integer catTurnosPk;
	private String nombre;
	private String borrado;
	private Set<RelEventoPuestos> relEventoPuestoses = new HashSet<RelEventoPuestos>(0);

	public CatTurnos() {
	}

	public CatTurnos(String nombre, String borrado) {
		this.nombre = nombre;
		this.borrado = borrado;
	}

	public CatTurnos(String nombre, String borrado, Set<RelEventoPuestos> relEventoPuestoses) {
		this.nombre = nombre;
		this.borrado = borrado;
		this.relEventoPuestoses = relEventoPuestoses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "CAT_TURNOS_PK", unique = true, nullable = false)
	public Integer getCatTurnosPk() {
		return this.catTurnosPk;
	}

	public void setCatTurnosPk(Integer catTurnosPk) {
		this.catTurnosPk = catTurnosPk;
	}

	@Column(name = "NOMBRE", nullable = false, length = 45)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catTurnos")
	public Set<RelEventoPuestos> getRelEventoPuestoses() {
		return this.relEventoPuestoses;
	}

	public void setRelEventoPuestoses(Set<RelEventoPuestos> relEventoPuestoses) {
		this.relEventoPuestoses = relEventoPuestoses;
	}

}