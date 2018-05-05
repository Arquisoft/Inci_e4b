package asw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.database.IncidenceRepository;
import asw.database.entities.Incidence;

/**
 * 
 * Elemento de comunicación entre los controladores e
 * IncidenceRepository
 *
 */
@Service
public class IncidenceService {

	@Autowired
	private IncidenceRepository incidenceRepo;
	
	public void addIncidence(Incidence inci) {
		incidenceRepo.save(inci);
	}
}
