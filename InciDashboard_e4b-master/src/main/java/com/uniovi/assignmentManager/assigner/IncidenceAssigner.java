package com.uniovi.assignmentManager.assigner;

/**
 * Interfaz que se usa para implementar un método que recibirá el id de una incidencia de la
 * base de datos y se encargará de asignar dicha incidencia a un operario.
 */
public interface IncidenceAssigner {

	/**
	 * Asigna una incidencia a un operario.
	 * @param incidenciaId -> Id de la incidencia a asignar, dicho id es el de la base de datos.
	 */
	void assign(Long incidenciaId);
	
}
