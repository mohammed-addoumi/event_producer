package com.simo.event_producer.batch.writer;

import lombok.RequiredArgsConstructor;

//@Configuration
@RequiredArgsConstructor
public class JdbcItemWriter {
	private static final String WRITER_NAME = "JdbcProducerWriter";
	
	/*private final EventRepository eventRepository;
	
	@Bean(name = WRITER_NAME)
	public ItemWriter<Event> jdbcItemWriter(){
		return list ->{
		    for(Event event:list) {event.setStatus("PROCESSED");}
			eventRepository.saveAll(list);};
	}*/
}
