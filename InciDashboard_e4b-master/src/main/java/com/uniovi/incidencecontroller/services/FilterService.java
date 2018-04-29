package com.uniovi.incidencecontroller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.uniovi.entities.FiltroPropiedades;
import com.uniovi.entities.Operario;
import com.uniovi.incidencecontroller.repositories.FilterRepository;

/**
 * Servicio encargado de la gestión entre el repositorio de filtros y la aplicación.
 */
@Service
public class FilterService {

	/**
	 * Repositorio de filtros, lo usaremos para actualizar la tabla de filtros.
	 */
	@Autowired
	private FilterRepository filterRepository;

	/**
	 * Servicio de operarios, lo usaremos porque los filtros van asignados a un operario.
	 */
	@Autowired
	private OperarioService operarioService;

	/**
	 * Llama al método findAll del repositorio de filtros y devuelve su resultado sin
	 * intervenir en él.
	 * @return Retorna una lista con todos los filtros de la base de datos.
	 */
	public List<FiltroPropiedades> findAll(){
		return filterRepository.findAll();
	}

	/**
	 * Llama al método findByOperario del repositorio de filtros y devuelve su resultado
	 * sin intervenir en él.
	 * @param operario -> Operario del que recuperaremos los filtros.
	 * @return Retorna una lista con los filtros de un operario.
	 */
	public List<FiltroPropiedades> findByOperario(Operario operario){
		return filterRepository.findByOperario(operario);
	}

	/**
	 * Comprueba quien es el operario que está en sesión para recuperar los filtros de este.
	 * @return Retorna una lista con los filtros del operario en sesión.
	 */
	public List<FiltroPropiedades> findByLogged(){
		UserDetails logged = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Operario operario = operarioService.findByDni(logged.getUsername()); 
		return findByOperario(operario);
	}

	/**
	 * Llama al método findById del repositorio de filtros y devuelve su resultado sin intervenir
	 * en él.
	 * @param id -> Id del filtro a buscar.
	 * @return Retorna el filtro con el id dado.
	 */
	public FiltroPropiedades findById(Long id) {
		return filterRepository.findById(id);
	}

	/**
	 * Añade un nuevo filtro a la base de datos, dicho filtro está creado por el operario en
	 * sesión, por lo tanto asignaremos el filtro al operario antes de guardarlo en la base de
	 * datos.
	 * @param filtro -> Filtro que acabamos de crear y vamos a asignar.
	 */
	public void addFilter(FiltroPropiedades filtro) {
		UserDetails logged = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Operario operario = operarioService.findByDni(logged.getUsername()); 
		filtro.setOperario(operario);
		filterRepository.save(filtro);
	}

	/**
	 * Borra un filtro de la base de datos.
	 * @param filtro -> Filtro a borrar.
	 */
	public void removeFilter(FiltroPropiedades filtro) {
		filterRepository.delete(filtro);
	}

}
