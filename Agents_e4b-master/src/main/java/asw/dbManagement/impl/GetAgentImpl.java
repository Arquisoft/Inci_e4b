package asw.dbManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.dbManagement.GetAgent;
import asw.dbManagement.model.Agent;
import asw.dbManagement.repository.AgentsRepository;


@Service
public class GetAgentImpl implements GetAgent {
	
	private AgentsRepository repository;
	
	@Autowired
	public GetAgentImpl(AgentsRepository repository) {
		this.repository = repository;
	}
	
	
	/**
	 * Método que devuelve el Agente buscado por identificador
	 * Hace uso del método findByIdentificador (mapeador)
	 */
	@Override
	public Agent getAgent(String identificador) {
		return this.repository.findByIdentificador(identificador);
	}

}
