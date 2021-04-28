package com.simo.event_producer.batch.writer;

import java.io.File;

import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.simo.event_producer.domain.Event;

@Configuration
public class EventProducerItemWriter {
	
	private static final String WRITER_NAME = "EventProducerWriter";
	
	@Bean(name = WRITER_NAME)
	public StaxEventItemWriter<Event> itemWriterConfig(){
		StaxEventItemWriter<Event> staxEventItemWriter = new StaxEventItemWriter<>();
		staxEventItemWriter.setResource(new FileSystemResource(new File("result.xml")));
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Event.class);
		staxEventItemWriter.setMarshaller(marshaller);
		staxEventItemWriter.setName(WRITER_NAME);
		staxEventItemWriter.setVersion("1.0");
		//staxEventItemWriter.setRootTagName("events");
		return staxEventItemWriter;
	}

}
