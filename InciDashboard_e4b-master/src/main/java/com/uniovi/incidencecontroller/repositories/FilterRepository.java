package com.uniovi.incidencecontroller.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.FiltroPropiedades;
import com.uniovi.entities.Operario;

/**
 * Repositorio que contacta con la base de datos para recuperar
 * los filtros solicitados.
 */
public interface FilterRepository extends CrudRepository<FiltroPropiedades,Long>{

	/**
	 * Recupera todos los filtros de la base de datos
	 * @return Retorna una lista con todos los filtros.
	 */
	List<FiltroPropiedades> findAll();
	
	/**
	 * Recupera los filtros de un operario dado.
	 * @param operario -> Operario del que buscaremos los filtros.
	 * @return Retorna una lista con los filtros del operario dado.
	 */
	List<FiltroPropiedades> findByOperario(Operario operario);
	
	/**
	 * Recupera el filtro con el id dado.
	 * @param id -> Id del filtro a buscar.
	 * @return Retorna el filtro con el id dado.
	 */
	FiltroPropiedades findById(Long id);
	
}
