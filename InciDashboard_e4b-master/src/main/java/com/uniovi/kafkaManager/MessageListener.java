package com.uniovi.kafkaManager;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.uniovi.assignmentManager.queue.IncidenceQueueImpl;

/**
 * Created by herminio on 28/12/16.
 */
 
@ManagedBean
public class MessageListener extends SpringBeanAutowiringSupport{

	@Autowired
	private IncidenceQueueImpl queue;
	
	private static final Logger logger = Logger.getLogger(MessageListener.class);

    @KafkaListener(topics = "incidence")
    public void listen(String data) {
        logger.info("New message received: \"" + data + "\"");
        queue.addIncidence(data);
    }



}