package asw.database;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import asw.database.entities.Incidence;
import asw.database.entities.extras.Status;

/**
 * 
 * Elemento encargado de la gestión de la persistencia de las incidencias 
 * en la base de datos. 
 *
 */
public interface IncidenceRepository extends CrudRepository<Incidence, Long> {

	public Set<Incidence> findByStatus(Status s);

}
