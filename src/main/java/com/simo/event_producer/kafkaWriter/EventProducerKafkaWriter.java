package com.simo.event_producer.kafkaWriter;

import org.springframework.batch.item.kafka.KafkaItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import com.simo.event_producer.domain.Event;

@Configuration
public class EventProducerKafkaWriter {
	
	private static final String WRITER_NAME = "kafkaEventProducerWriter";
	
	@Bean(name = WRITER_NAME,destroyMethod = "")
	public KafkaItemWriter<Integer, Event> kafkaItemWriterConfig(KafkaTemplate<Integer, Event> kafkaTemplate){
		KafkaItemWriter<Integer, Event> kafkaItemWriter=new KafkaItemWriter<Integer, Event>();
		kafkaItemWriter.setKafkaTemplate(kafkaTemplate);
		kafkaItemWriter.setItemKeyMapper(Event::getId);
		return kafkaItemWriter;	
	}

}
