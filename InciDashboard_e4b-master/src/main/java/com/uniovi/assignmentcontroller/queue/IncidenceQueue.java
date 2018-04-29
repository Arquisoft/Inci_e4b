package com.uniovi.assignmentcontroller.queue;

/**
 * Interfaz encargada de implementar los métodos necesarios para añadir una incidencia
 * recibida desde Kafka, en caso de cambiar la forma de añadir una incidencia se cambiará
 * la implementación del método de la interfaz.
 */
public interface IncidenceQueue {

	/**
	 * Método que recibirá el texto de Kafka y gestionará la incidencia de forma que el
	 * resultado de este método será el que se envie al IncidenceAssigner.
	 * @param incidenceText -> Texto recibido desde Kafka.
	 */
	void addIncidence(String incidenceText);
	
}
