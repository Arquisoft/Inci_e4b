package com.uniovi.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.uniovi.entities.extras.Location;
import com.uniovi.entities.extras.Status;

/**
 * <p>La entidad incidencia es una de las entidades más importantes del dashboard ya que es 
 * en lo que se basa toda la gestión, se reciben incidencias, se asignan incidencias y 
 * se revisan incidencias.</p>
 *<p>Una incidencia tiene varios campos, entre ellos los más importantes serán el id de la 
 *incidencia ya que este es el mismo que se usa en la base de datos y el que se usa para 
 *ejecutar querys, además de esto tenemos la localización ya que será posible geolocalizar una
 *incidencia.<br>
 *También tenemos tags para hacernos una idea de que contenido tiene la incidencia y los fields
 *de la incidencia, cada campo de la incidencia tiene un valor, estos valores se usan para 
 *controlar si una incidencia es peligrosa o no, además de esto una incidencia tiene un Operario
 *que es el operario al que se le ha asignado esta incidencia.</p>
 */
@Entity
public class Incidencia {
	/**
	 * Numero de identificacion de la incidencia
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * Nombre de la incidencia
	 */
	private String incidenceName;	
	
	/**
	 * Descripción de la incidencia
	 */
	private String description;	
	
	/**
	 * Localizacion de la incidencia
	 */
	private Location location;
	
	/**
	 * Etiquetas
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> tags;
	
	/**
	 * Campos de la incidencia
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<String, String> fields;

	/**
	 * Estado de la incidencia (ABIERTA,	EN PROCESO,	CERRADA, ANULADA)
	 */
	@Enumerated(EnumType.STRING)
	private Status status = Status.ABIERTA;
	
	/**
	 * Comentarios sobre la incidencia
	 */
	private String comments;
	
	/**
	 * Fecha en la que expira la incidencia
	 */
	private Date expirationDate;

	/**
	 * Operario al cual esta asignada la incidencia
	 */
	@ManyToOne
	@JoinColumn(name = "operario")
	private Operario operario;
	
	
	/**
	 * Constructor vacio
	 */
	public Incidencia() {}
	
	/**
	 * Constructor con todos los atributos pasados por parametro
	 * @param incidenceName, nombre de incidencia
	 * @param descripcion, descripcion de la incidencia
	 * @param location, localizacion de la incidencia
	 * @param tags, etiquetas
	 * @param fields, campos
	 * @param status, estado de la incidencia
	 * @param comments, comentarios adicionales
	 * @param expirationDate, fecha de expiracion
	 */
	public Incidencia(String incidenceName, String descripcion, Location location, 
				List<String> tags, HashMap<String, String> fields, Status status, String comments, Date expirationDate) {
		this.incidenceName = incidenceName;
		this.description = descripcion;
		this.location = location;
		this.tags = tags;
		this.fields = fields;
		this.status = status;
		this.comments = comments;
		this.expirationDate = expirationDate;
	}

	/**
	 * Constructor para inicializar la incidencia con otros parámetros.
	 */
	public Incidencia(String incidenceName, String descripcion, Location location, List<String> tags) {
		this.incidenceName = incidenceName;
		this.description = descripcion;
		this.location = location;
		this.tags = tags;
		this.expirationDate = new Date();
	}
	
	/**
	 * Constructor para inicializar la incidencia con otros parámetros.
	 */
	public Incidencia(String incidenceName, String description, Location location) {
		this.incidenceName = incidenceName;
		this.description = description;
		this.location = location;
		this.expirationDate = new Date();
	}

	/**
	 * Devuelve el numero de identificacion
	 * @return id, identificacion
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Asigna el numero de identificacion
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre de la incidencia
	 * @return incidenceName
	 */
	public String getIncidenceName() {
		return incidenceName;
	}

	/**
	 * Asigna el nombre de la incidencia
	 * @param incidenceName
	 */
	public void setIncidenceName(String incidenceName) {
		this.incidenceName = incidenceName;
	}

	/**
	 * Devuelve la descripcion de la incidencia
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Asigna una descripcion a la incidencia
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Devuelve la localizacion de la incidencia
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Asigna una localizacion a la incidencia
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Devuelve una lista de etiquetas que contiene la incidencia
	 * @return tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * Asigna la lista de etiquetas
	 * @param tags
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * Devuelve los campos de la incidencia
	 * @return
	 */
	public Map<String, String> getFields() {
		return fields;
	}

	/**
	 * Asigna los campos de la incidencia
	 * @param fields
	 */
	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}

	/**
	 * Devuelve el estado de la incidencia
	 * @return
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Asigna el estado de la incidencia
	 * (Se usa el enum 'Status'= { ABIERTA, EN_PROCESO, CERRADA, ANULADA }
	 * @param status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Devuelve los comentarios de la incidencia
	 * @return comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Asigna una cadena con los comentarios de la incidencia
	 * @param comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * Devuelve la fecha de expiracion de la incidencia
	 * @return expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Asigna la fecha de expiracion de la incidencia
	 * @param expirationDate
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Devuelve el operario asignado a la incidencia
	 * @return
	 */
	public Operario getOperario() {
		return operario;
	}

	/**
	 * Cambia al operario encargado de la incidencia
	 * @param operario
	 */
	public void setOperario(Operario operario) {
		this.operario = operario;
	}
	
	/**
	 * Retorna si el estado recibido es el estado actual de la incidencia.
	 * @param estado -> Estado a comprobar.
	 * @return Retorna ture en caso de que el estado recibido sea el de la incidencia 
	 * o false en caso de que no sea así.
	 */
	public boolean statusIs(String estado) {
		if(status.equals(Status.ABIERTA) && "ABIERTA".equals(estado))
			return true;
		if(status.equals(Status.CERRADA) && "CERRADA".equals(estado))
			return true;
		if(status.equals(Status.EN_PROCESO) && "EN_PROCESO".equals(estado))
			return true;
		return status.equals(Status.ANULADA) && "ANULADA".equals(estado);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidencia other = (Incidencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Incidence [incidenceName= " + incidenceName + ", description= " + description + 
				", location= " + location + ", tags= " + tags + ", fields= " + fields + 
					", comments= " + comments  + ", status= " + status + 
						", expirationDate= " + expirationDate + "]";
	}
	
}