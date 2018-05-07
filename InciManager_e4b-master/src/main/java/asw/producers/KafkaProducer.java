package asw.producers;

import java.io.IOException;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import asw.database.entities.Incidence;

/**
 * 
 * Elemento encargado de la comunicación con el módulo InciDashboard
 * a través de la tecnología externa Kafka. 
 * Se comunica de forma asíncrona mediante JSON.
 *
 */
@ManagedBean
public class KafkaProducer {

	private static final Logger logger = Logger.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	/**
	 * Convierte una incidencia a formato JSON para posteriormente
	 * enviarla al módulo InciDashboard para su gestión.
	 */
	public void send(String topic, Incidence incidence) {

		try {
			this.send(topic, this.IncidenceToJson(incidence));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}
	
	public String IncidenceIdToJson(Incidence i) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();

		ObjectWriter json = mapper.writerWithDefaultPrettyPrinter();

		return json.writeValueAsString(i.getId());
	}

	public String IncidenceToJson(Incidence o) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();

		ObjectWriter json = mapper.writerWithDefaultPrettyPrinter();

		return json.writeValueAsString(o);
	}

	public Incidence JsonToIncidence(String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		return mapper.readValue(json, Incidence.class);
	}
	
	/**
	 * Recibe un mensaje que debe estar construido acorde al formato JSON
	 * para enviarlo al módulo InciDashboard para su posterior gestión.
	 */
	public void send(String topic, String data) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, data);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onSuccess(SendResult<String, String> result) {
				logger.info("Success on sending message \"" + data + "\" to topic " + topic);
			}

			@Override
			public void onFailure(Throwable ex) {
				logger.error("Error on sending message \"" + data + "\", stacktrace " + ex.getMessage());
			}
		});
	}

}
