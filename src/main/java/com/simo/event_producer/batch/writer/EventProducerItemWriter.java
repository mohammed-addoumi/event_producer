package com.simo.event_producer.batch.writer;

import java.io.File;

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
	
	/*@Bean(name = WRITER_NAME)
	public JdbcBatchItemWriter<Event> itemWriterConfig(DataSource dataSource,NamedParameterJdbcTemplate jdbcTemplate){
		JdbcBatchItemWriter<Event> itemWriter = new JdbcBatchItemWriter<Event>();
		itemWriter.setDataSource(dataSource);
		BeanPropertyItemSqlParameterSourceProvider<Event> provider = new BeanPropertyItemSqlParameterSourceProvider<Event>();
		itemWriter.setSql("INSERT INTO event_duplicate(id,name,event_type,status) VALUES(:id,:name,:event_type,:status)");
		itemWriter.setJdbcTemplate(jdbcTemplate);
		itemWriter.setItemSqlParameterSourceProvider(provider);
		return itemWriter;
	}
	
    @Bean(name ="namedParameterJdbcTemplate" )
    NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }*/
	}
	
