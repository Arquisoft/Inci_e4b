package com.uniovi.dangercontroller;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;

/**
 * DangerAssigner es la interfaz encargada de comprobar si una incidencia tiene
 * valores peligrosos para los filtros de un operario.
 */
public interface DangerAssigner {

	/**
	 * Comprueba si la incidencia recibida es peligrosa para el operario recibido.
	 * @param incidencia -> Incidencia a comprobar si es peligrosa.
	 * @param operario -> Operario al que se le asignó dicha incidencia.
	 */
	boolean checkDanger(Incidencia incidencia, Operario operario);
	
}
