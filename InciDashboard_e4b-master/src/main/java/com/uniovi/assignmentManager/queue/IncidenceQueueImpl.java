package com.uniovi.assignmentManager.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.assignmentManager.assigner.IncidenceAssigner;

/**
 * Implementación de la interfaz IncidenceQueue, por lo tanto esta clase es la encargada
 * de gestionar el texto recibido desde Kafka y enviar el resultado de la gestión al
 * incidenceAssigner para su posterior asignación.
 */
@Service
public class IncidenceQueueImpl implements IncidenceQueue{
	
	/**
	 * IncidenceAssigner se usa para ejecutar la asignación de una incidencia a un
	 * operario.
	 */
	@Autowired
	private IncidenceAssigner incidenceAssigner;
	
	/**
	 * En este caso el texto recibido desde Kafka será el Id de la incidencia añadida a la 
	 * base de datos, por lo tanto lo único que se hará en este método será transformar
	 * dicha incidencia a un Long, tipo de dato de los Id en la base de datos, y enviarla 
	 * al asignador.
	 */
	@Override
	public void addIncidence(String incidenceText) {
		Long incidenceId = Long.valueOf(incidenceText);
		incidenceAssigner.assign(incidenceId);
	}

}
