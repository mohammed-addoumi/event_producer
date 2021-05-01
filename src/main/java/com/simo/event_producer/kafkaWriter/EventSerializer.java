package com.simo.event_producer.kafkaWriter;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simo.event_producer.domain.Event;

public class EventSerializer implements Serializer<Event>{

	@Override
	public byte[] serialize(String topic, Event data) {
		   byte[] retVal = null;
		   ObjectMapper objectMapper = new ObjectMapper();
		   try {
			retVal = objectMapper.writeValueAsString(data).getBytes();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return retVal;
	}

}
