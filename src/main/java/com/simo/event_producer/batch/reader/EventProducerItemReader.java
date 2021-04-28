package com.simo.event_producer.batch.reader;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simo.event_producer.domain.Event;

@Configuration
public class EventProducerItemReader {
	
	private static final String READER_NAME = "EventProducerReader";
	
	
	
	@Bean(name = READER_NAME)
	public ItemReader<Event> itemReaderConfig(DataSource dataSource){
		JdbcCursorItemReader<Event> jdbcCursorItemReader = new JdbcCursorItemReader<>();
		
				jdbcCursorItemReader.setDataSource(dataSource);
				jdbcCursorItemReader.setSql("select id,name,event_type,status from event");
				jdbcCursorItemReader.setIgnoreWarnings(true);
				jdbcCursorItemReader.setVerifyCursorPosition(true);	
				jdbcCursorItemReader.setRowMapper(new EventProducerRowMapper());
				jdbcCursorItemReader.setFetchSize(10);
				
				return jdbcCursorItemReader;
		
	}
	

}
