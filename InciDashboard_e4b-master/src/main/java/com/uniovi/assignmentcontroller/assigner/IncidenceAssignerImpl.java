package com.uniovi.assignmentcontroller.assigner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.dangercontroller.CheckDangerImpl;
import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Notificacion;
import com.uniovi.entities.Operario;
import com.uniovi.incidencecontroller.services.IncidenceService;
import com.uniovi.incidencecontroller.services.NotificacionService;
import com.uniovi.incidencecontroller.services.OperarioService;

/**
 * Clase que implementa la interfaz IncidenceAssigner, por lo tanto es la 
 * clase encargada de asignar una incidencia a un operario, en este caso la estrategia
 * elegida para asignar una incidencia es asignar las incidencias que llegan al operario
 * con menos incidencias en el momento de llegada.
 */
@Service
public class IncidenceAssignerImpl implements IncidenceAssigner{

	/**
	 * Usaremos el OperarioService para recuperar a todos los operarios de la base
	 * de datos y elegir al más adecuado para recibir la incidencia.
	 */
	@Autowired
	private OperarioService operarioService;
	
	/**
	 * Usaremos el IncidenceService para recuperar la incidencia con el id dado de la
	 * base de datos y asignarsela a un operario.
	 */
	@Autowired
	private IncidenceService incidenceService;
	
	/**
	 * Usaremos el NotificacionService para añadir una notificacion en caso de que la 
	 * incidencia sea peligrosa en la base de datos y se le notifique rapidamente al operario
	 */
	@Autowired
	private NotificacionService notificacionService;
	
	/**
	 * Usaremos la implementación del DangerAssigner para comprobar si una incidencia
	 * es peligrosa según los filtros del operario a la que se le asigna dicha incidencia.
	 */
	@Autowired
	private CheckDangerImpl dangerAssigner;
	
	/**
	 * Asigna una incidencia a un operario dado por el método chooseOperario y después de 
	 * asignar dicha incidencia comprueba si es peligrosa para los filtros del operario dado.
	 */
	@Override
	public void assign(Long id) {
		Operario toAssign = chooseOperario();
		Incidencia incidencia = incidenceService.findById(id);
		incidencia.setOperario(toAssign);
		if(dangerAssigner.checkDanger(incidencia, toAssign)) {
			Notificacion notificacion = new Notificacion("Incidencia peligrosa" + incidencia.getIncidenceName());
			notificacion.setOperario(toAssign);
			notificacion.setIncidencia(incidencia);
			incidencia.getNotificaciones().add(notificacion);
			toAssign.getNotificaciones().add(notificacion);
			notificacionService.addNotificacion(notificacion);
		}
		
		
		incidenceService.saveIncidence(incidencia);
	}
	
	/**
	 * Recupera a todos los operarios de la base de datos y los ordena por orden
	 * de incidencias recibidas, por lo tanto el operario que menos incidencias tenga
	 * será el operario al que se le asigne la incidencia.
	 * @return Retorna al operario con menos incidencias asignadas en el momento dado.
	 */
	private Operario chooseOperario() {
		List<Operario> operarios = operarioService.findAll();
		operarios.sort((o1, o2) -> Integer.compare(o1.getIncidencias().size(), o2.getIncidencias().size()));
		
		if(operarios.size()>0)
			return operarios.get(0);
		
		return null;
	}

}
