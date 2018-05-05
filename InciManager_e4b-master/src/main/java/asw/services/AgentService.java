package asw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.database.AgentsRepository;
import asw.database.entities.Agent;

/**
 * 
 * Elemento de comunicación entre los controladores y
 * AgentsRepository
 *
 */
@Service
public class AgentService {

	@Autowired
	private AgentsRepository agentsRepository;
	
	public Agent getAgentByEmail(String email) {
		return agentsRepository.findByEmail(email);
	}
}
