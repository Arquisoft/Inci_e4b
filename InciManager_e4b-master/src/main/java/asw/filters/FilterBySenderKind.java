package asw.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.database.AgentsRepository;
import asw.database.entities.Agent;
import asw.database.entities.Incidence;

/**
 * 
 * Elemento que filtra las incidencias por el tipo del
 * que la ha generado. Da como correctas las incidencias
 * enviadas por personas o entidades, pero como incorrectas
 * las enviadas por sensores.
 *
 */
@Service
public class FilterBySenderKind implements Filter{

	@Autowired
	AgentsRepository agentRepository;
	
	/**
	 * @param Incidence i: Incidencia a filtrar.
	 * @return boolean: true si la incidencia ha sido enviada
	 * 		por una persona o entidad, false si ha sido enviada
	 * 		por un sensor.
	 */
	@Override
	public boolean filtrar(Incidence i) {
		String emailSender = i.getUser();
		Agent sender = agentRepository.findByEmail(emailSender);
		String senderKind = sender.getTipo().getType();
		if(senderKind.equals("Person") || senderKind.equals("Entidad"))
			return true;
		if(senderKind.equals("Sensor"))
			return false;
		else
			return false;
	}

}
