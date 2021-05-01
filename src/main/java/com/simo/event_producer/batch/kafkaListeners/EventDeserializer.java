package com.simo.event_producer.batch.kafkaListeners;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simo.event_producer.domain.Event;

public class EventDeserializer implements Deserializer<Event>{

	@Override
	public Event deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		Event event = null;
		try {
			event = mapper.readValue(data, Event.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;
	}

}
