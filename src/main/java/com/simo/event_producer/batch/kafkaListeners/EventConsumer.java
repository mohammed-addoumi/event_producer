package com.simo.event_producer.batch.kafkaListeners;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.simo.event_producer.domain.Event;

@Component
public class EventConsumer {
	
	@KafkaListener(topics = "${consumer.topic}",groupId = "${consumer.groupId}")
	public void eventConsume(ConsumerRecord<Integer, Event> record) {
		System.out.println("the event kafka listener : ");
		System.out.println(record.value());
	}

}
