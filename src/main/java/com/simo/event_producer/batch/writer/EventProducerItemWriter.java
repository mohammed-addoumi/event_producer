package com.simo.event_producer.batch.writer;

import java.io.File;
import java.util.Arrays;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.kafka.KafkaItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.simo.event_producer.domain.Event;

@Configuration
public class EventProducerItemWriter {
	
	private static final String WRITER_NAME = "EventProducerWriter";

	
	@Bean(name = WRITER_NAME,destroyMethod = "")
	public CustomStaxEventItemWriter<Event> itemWriter1Config(){
		CustomStaxEventItemWriter<Event> ItemWriter = new CustomStaxEventItemWriter<>();
		ItemWriter.setResource(new FileSystemResource(new File("results/result.xml")));
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Event.class);
		ItemWriter.setMarshaller(marshaller);
		ItemWriter.setName(WRITER_NAME);
		ItemWriter.setVersion("1.0");
		ItemWriter.setRootTagName("events");
		return ItemWriter;
	}
	
	@Bean(name = "compositeItemWriter",destroyMethod = "")
	public CompositeItemWriter<Event> compositeItemWriter(KafkaItemWriter<Integer, Event> kafkaItemWriter
			                                              ,CustomStaxEventItemWriter<Event> itemWriter) {
		CompositeItemWriter<Event> compositeItemWriter = new CompositeItemWriter<Event>();
		compositeItemWriter.setDelegates(Arrays.asList(kafkaItemWriter,itemWriter));
		return compositeItemWriter;
	}
	
	}
	
