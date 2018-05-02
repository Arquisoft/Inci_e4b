package com.uniovi.incidencecontroller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Notificacion;
import com.uniovi.incidencecontroller.repositories.NotificacionRepository;

/**
 * Servicio encargado de comunicarse con el repositorio de notificaciones.
 */
@Service
public class NotificacionService {
	
	/**
	 * Repositorio de notificaciones.
	 */
	@Autowired
	private NotificacionRepository nr;
	
	/**
	 * Añade una nueva notificación a la base de datos.
	 * @param notificacion
	 */
	public void addNotificacion(Notificacion notificacion) {
		nr.save(notificacion);
	}
	
	/**
	 * Llama al método findAll del repositorio y devuelve el resultado.
	 * @return Retorna todas las notificaciones de la base de datos.
	 */
	public List<Notificacion> getAllNotificacion(){
		return nr.findAll();
	}
	
	/**
	 * Llama al método findByOperario y devuelve el resultado.
	 * @param pageable -> Configuración de la página. 
	 * @param id -> Id del operario dueño de las notificaciones.
	 * @return Devuelve una página con las notificaciones del operario dado.
	 */
	public Page<Notificacion> getNotificacionPorOperario(Pageable pageable, Long id){
		return nr.findByOperario(pageable,id);
	}
	
	public Page<Notificacion> getNotificacion(Pageable pageable, Long id){
		return nr.findById(pageable, id);
	}
	
	public void deleteNotificacion(Long id) {
		nr.delete(id);
	}

}
