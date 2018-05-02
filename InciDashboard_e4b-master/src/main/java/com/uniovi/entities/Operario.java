package com.uniovi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * <p>Entidad operario, el operario es el encargado de la gestión de incidencias, por lo tanto
 * es el usuario del dashboard, los datos más importantes del operario serán el id, el dni y 
 * la contraseña, a partir del id se recupera toda la información de la base de datos y el dni
 * y la contraseña son necesarios para acceder al dashboard. </p>
 * <p>
 * Un operario tiene una lista de incidencias que son las incidencias asignadas a dicho operario,
 * además de esto tiene una lista de notificaciones que son las notificaciones recibidas cuando
 * se le asigna una incidencia considerada peligrosa por sus filtros.
 * </p>
 */
@Entity
public class Operario {

	/**
	 * Id del operario en la base de datos.
	 */
	@Id
	@GeneratedValue
	private long id;
	
	/**
	 * Nombre del operario.
	 */
	private String nombre;
	
	/**
	 * Dni del operario, debe ser único.
	 */
	@Column(unique=true)
	private String dni;
	
	/**
	 * Lista de incidencias del operario, dado el tipo de "fetch" que estamos usando, las 
	 * incidencias se recuperan al momento y no es necesario usar código para recuperarlas.
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "operario", cascade = CascadeType.ALL)
	private List<Incidencia> incidencias;
	
	/**
	 * Contraseña del operario.
	 */
	private String password;
	
	/**
	 * Campo de repetición de contraseña, no se guarda en la base de datos.
	 */
	@Transient
	private String passwordConfirm;
	
	/**
	 * Notificaciones del operario.
	 */
	@OneToMany
	private List<Notificacion> notificaciones = new ArrayList<Notificacion>();

	/**
	 * Constructor vacio del Operario, se usa para crear el bean.
	 */
	public Operario() { }
	
	/**
	 * Constructor para que un operario tenga un nombre y un dni.
	 * @param nombre -> Nombre del operario.
	 * @param dni -> Dni del operario.
	 */
	public Operario(String nombre, String dni) {
		this(nombre, dni, new ArrayList<Incidencia>());
	}
	
	/**
	 * Constructor para que un operario tenga un nombre y un dni.
	 * @param nombre -> Nombre del operario.
	 * @param dni -> Dni del operario.
	 * @param incidencia -> Lista de incidencias que el operario tiene asignadas.
	 */
	public Operario(String nombre, String dni, List<Incidencia> incidencia) {
		this.nombre = nombre;
		this.dni = dni;
		this.incidencias = incidencia;
	}
	
	/**
	 * Getter del atributo id.
	 * @return Retorna el valor del id.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Setter del atributo id.
	 * @param id -> Asigna el id dado.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter del atributo nombre.
	 * @return Retorna el valor del nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter del atributo nombre.
	 * @param nombre -> Asigna el valor dado.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter del atributo dni.
	 * @return Retorna el valor del dni.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Setter del atributo dni.
	 * @param dni -> Asigna el valor dado.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Getter del atributo password.
	 * @return Retorna el valor del campo password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter del atributo password.
	 * @param password -> Asigna el valor dado.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter del atributo passwordConfirm.
	 * @return Retorna el valor del campo passwordConfirm.
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * Setter del atributo passwordConfirm.
	 * @param passwordConfirm -> Asigna el valor dado.
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	/**
	 * Getter del atributo incidencias.
	 * @return Retorna el valor de las incidencias.
	 */
	public List<Incidencia> getIncidencias() {
		return incidencias;
	}

	/**
	 * Setter del atributo incidencias.
	 * @param incidencias -> Asigna el valor dado.
	 */
	public void setIncidencias(List<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}

	/**
	 * Getter del atributo notificaciones.
	 * @return Retorna el valor de las notificaciones.
	 */
	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	
	
}
