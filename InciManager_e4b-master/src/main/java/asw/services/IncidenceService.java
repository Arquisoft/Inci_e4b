package asw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.database.IncidenceRepository;
import asw.database.entities.Incidence;
import asw.database.entities.Message;
import asw.producers.KafkaProducer;

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

    @Autowired
    private KafkaProducer kafkaProducer;
	
	public void addIncidence(Incidence inci) {
		incidenceRepo.save(inci);
	}
	
	public void sendIncidence(Message message) {
		kafkaProducer.send("incidence", message.getMessage());
	}
	
	public void sendIncidence(String message) {
		kafkaProducer.send("incidence", message);
	}
}
