package asw.database.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Operario operario;

	private String comentario;

	@ManyToOne
	private Incidence incidencia;

	public Notificacion() {
	}

	public Notificacion(String comentario) {
		this.comentario = comentario;
	}

	public Operario getOperario() {
		return operario;
	}

	public void setOperario(Operario operario) {
		this.operario = operario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Devuelve la incidencia de la cual notifica
	 * @return incidencia
	 */
	public Incidence getIncidencia() {
		return incidencia;
	}
	
	public void setIncidencia(Incidence incidencia) {
		this.incidencia = incidencia;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((operario == null) ? 0 : operario.hashCode());
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
		Notificacion other = (Notificacion) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
