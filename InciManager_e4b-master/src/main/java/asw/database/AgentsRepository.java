package asw.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.database.entities.Agent;

/**
 * 
 * Elemento encargado de la gestión de la persistencia de los agentes 
 * en la base de datos. Utiliza la base de datos como sistema de 
 * comunicación con el módulo Agents.
 *
 */
@Repository
public interface AgentsRepository extends CrudRepository<Agent, Long> {
	
	public Agent findByEmail(String email);
	
	
	public Agent findByIdentificador(String identificador);
	
}
