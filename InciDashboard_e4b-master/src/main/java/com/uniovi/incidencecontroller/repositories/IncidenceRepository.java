package com.uniovi.incidencecontroller.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.entities.extras.Status;

/**
 * Repositorio encargado de gestionar la conexión con la tabla de incidencias en la
 * base de datos.
 */
public interface IncidenceRepository extends CrudRepository<Incidencia, Long>{

	/**
	 * Recupera todas las incidencias de la base de datos.
	 * @return Retorna una lista con todas las incidencias.
	 */
	List<Incidencia> findAll();
	
	/**
	 * Recupera las incidencias asignadas a un operario.
	 * @param operario -> Operario del que queremos recuperar las incidencias.
	 * @return Retorna una lista con todas las incidencias del operario dado.
	 */
	List<Incidencia> findByOperario(Operario operario);
	
	/**
	 * Recupera la incidencia con el id dado.
	 * @param id -> Id de la incidencia a buscar.
	 * @return Retorna la incidencia con el id dado.
	 */
	Incidencia findById(Long id);
	
	/**
	 * Actualiza una incidencia para colocarle un estado nuevo.
	 * @param nuevoEstado -> Estado a colocar.
	 * @param id -> Id de la incidencia a actualizar.
	 */
	@Transactional
	@Modifying
	@Query("UPDATE Incidencia SET status=?1 WHERE id=?2")
	void updateIncidenciaStatus(Status nuevoEstado, Long id);
	
}