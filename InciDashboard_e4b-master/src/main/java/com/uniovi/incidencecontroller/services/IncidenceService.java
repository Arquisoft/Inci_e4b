package com.uniovi.incidencecontroller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.entities.extras.Status;
import com.uniovi.incidencecontroller.repositories.IncidenceRepository;

/**
 * Servicio encargado de comunicar el repositorio de incidencias con el resto de la aplicación.
 */
@Service
public class IncidenceService {
	
	/**
	 * Repositorio de incidencias, será el único repositorio con el que se comunique este
	 * servicio.
	 */
	@Autowired
	private IncidenceRepository incidenceRepository;
	
	/**
	 * Llama al método findAll del repositorio y devolverá el resultado sin tocarlo.
	 * @return Retorna una lista con todas las incidencias de la base de datos.
	 */
	public List<Incidencia> findAll(){
		return incidenceRepository.findAll();
	}
	
	/**
	 * Llama al método findByOperario del repositorio y devolverá el resultado sin tocarlo.
	 * @return Retorna una lista con todas las incidencias del operario dado.
	 */
	public List<Incidencia> findByOperario(Operario operario){
		return incidenceRepository.findByOperario(operario);
	}
	
	/**
	 * Llama al método findById del repositorio y devolverá el resultado sin tocarlo.
	 * @return Retorna la incidencia con el id dado.
	 */
	public Incidencia findById(Long id) {
		return incidenceRepository.findById(id);
	}
	
	/**
	 * Guarda una nueva incidencia en la base de datos.
	 * @param incidencia -> Incidencia a guardar.
	 */
	public void saveIncidence(Incidencia incidencia) {
		incidenceRepository.save(incidencia);
	}
	
	/**
	 * Borra una incidencia de la base de datos.
	 * @param incidencia -> Incidencia a borrar.
	 */
	public void removeIncidence(Incidencia incidencia) {
		incidenceRepository.delete(incidencia);
	}
	
	/**
	 * Actualiza el estado de una incidencia.
	 * @param id -> Id de la incidencia a actualizar.
	 * @param estado -> Nuevo estado para la incidencia
	 */
	public void updateStatusIncidence(Long id, String estado) {
		if("abierta".equals(estado))
			incidenceRepository.updateIncidenciaStatus(Status.ABIERTA, id);
		else if("enProceso".equals(estado))
			incidenceRepository.updateIncidenciaStatus(Status.EN_PROCESO, id);
		else if("cerrada".equals(estado))
			incidenceRepository.updateIncidenciaStatus(Status.CERRADA, id);
		else if("anulada".equals(estado))
			incidenceRepository.updateIncidenciaStatus(Status.ANULADA, id);
	}
	
}
