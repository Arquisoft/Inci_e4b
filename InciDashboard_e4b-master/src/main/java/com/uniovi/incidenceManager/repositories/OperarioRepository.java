package com.uniovi.incidenceManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Operario;

/**
 * Repositorio encargado de gestionar la conexión con la tabla de operarios.
 */
public interface OperarioRepository extends CrudRepository<Operario,Long>{

	/**
	 * Recupera todos los operarios de la base de datos.
	 * @return Retorna una lista con todos los operarios.
	 */
	List<Operario> findAll();
	
	/**
	 * Recupera a un operario dado el dni de este.
	 * @param dni -> Dni del operario a buscar.
	 * @return Retorna al operario con el dni dado.
	 */
	Operario findByDni(String dni);
	
	/**
	 * Recupera al operario con el id dado.
	 * @param id -> Id del operario a buscar.
	 * @return Retorna al operario con el id dado.
	 */
	Operario findById(long id);
	
}
