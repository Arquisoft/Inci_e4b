package com.uniovi.incidencecontroller.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uniovi.entities.Notificacion;

/**
 * Repositorio encargado de gestionar la conexión con la tabla de notificaciones.
 */
@Repository
public interface NotificacionRepository extends CrudRepository<Notificacion, Long>{

	/**
	 * Recupera todas las notificaciones de la base de datos.
	 * @return Retorna una lista con todas las notificaciones.
	 */
	List<Notificacion> findAll();
	
	/**
	 * Recupera las notificaciones de un operario y las pagina.
	 * @param pageable -> Configuración de la página.
	 * @param operario -> Operario del que buscaremos las notificaciones.
	 * @return Retorna una página con las notificaciones de un operario dado.
	 */
	Page<Notificacion> findByOperario(Pageable pageable, Long operario);
	

}
