package beans.model;
// default package
// Generated 08-dic-2018 17:21:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name = "USUARIOS", catalog = "quilicuabd")
public class Usuarios implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer usuariosPk;
	private String nombre;
	private String password;
	private String borrado;

	public Usuarios() {
	}

	public Usuarios(String nombre, String password, String borrado) {
		this.nombre = nombre;
		this.password = password;
		this.borrado = borrado;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "USUARIOS_PK", unique = true, nullable = false)
	public Integer getUsuariosPk() {
		return this.usuariosPk;
	}

	public void setUsuariosPk(Integer usuariosPk) {
		this.usuariosPk = usuariosPk;
	}

	@Column(name = "NOMBRE", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "PASSWORD", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "BORRADO", nullable = false, length = 1)
	public String getBorrado() {
		return this.borrado;
	}

	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}

}
