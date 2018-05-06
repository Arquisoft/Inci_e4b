package com.uniovi.dangerManager;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.FiltroPropiedades;
import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.incidenceManager.services.FilterService;

/**
 * Clase que implementa la interfaz DangerAssigner, por lo tanto, clase encargada de comprobar
 * si la incidencia dada es peligorsa para un operario dado.
 */
@Service
public class CheckDangerImpl implements DangerAssigner{

	/**
	 * FilterService se usará para recuperar todos los filtros del operario dado.
	 */
	@Autowired
	private FilterService filterService;
	
	/**
	 * Logger para enviar mensajes por la salida estandar.
	 */
	private static final Logger logger = Logger.getLogger(CheckDangerImpl.class);
	
	/**
	 * Método encargado de recuperar una lista con todos los filtros del operario 
	 * y comprobar si la incidencia es peligorsa para alguno de los filtros dados,
	 * en caso de que sea peligroso habrá que enviar una notificación al operario.
	 */
	@Override
	public boolean checkDanger(Incidencia incidencia, Operario operario) {
		List<FiltroPropiedades> filtros = filterService.findByOperario(operario);
		boolean es_peligrosa = false;
		for(FiltroPropiedades filtro : filtros) {
			if(filtro.applicateFilter(incidencia)) {
				logger.info("La incidencia " + incidencia.getId() + " se considera peligrosa por el filtro " + filtro.getId());
				es_peligrosa = true;
			}
		}
		return es_peligrosa;
	}

}
