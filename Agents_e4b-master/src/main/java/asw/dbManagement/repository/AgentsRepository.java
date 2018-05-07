package asw.dbManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asw.dbManagement.model.Agent;

@Repository
public interface AgentsRepository extends CrudRepository<Agent, Long> {
	
	/**
	 * Método que devuelve el Agent el cual es buscado por email
	 * en la base de datos
	 * @param email del Agent
	 * @return El Agent con dicho email
	 */
	public Agent findByEmail(String email);
	
	/**Metodo que nos permite encontrar un agente buscado en este caso por su identificador(usuario)
	 * 
	 * @param identificador
	 * @return el agente con dicho identificador
	 */
	public Agent findByIdentificador(String identificador);

}
