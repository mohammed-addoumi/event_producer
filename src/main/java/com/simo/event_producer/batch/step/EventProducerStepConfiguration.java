package com.simo.event_producer.batch.step;


import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simo.event_producer.domain.Event;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class EventProducerStepConfiguration {
	
	private static final String STEP_NAME="EventProducerStep";
	
	private final StepBuilderFactory stepBuilderFactory;
	
	private final ItemWriter<Event> eventProduceritemWriter;
	
	private final ItemReader<Event> eventProduceritemReader;
	
	//private final PlatformTransactionManager transactionManager;
	
	
	@Bean(name = STEP_NAME)
	public Step stepConfig() {
		return stepBuilderFactory
			   .get(STEP_NAME)
			   .<Event,Event>chunk(4)
			   .reader(eventProduceritemReader)
			   .writer(eventProduceritemWriter)
			   .build();
			
	}

}
