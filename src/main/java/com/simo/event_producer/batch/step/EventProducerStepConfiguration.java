package com.simo.event_producer.batch.step;


import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.simo.event_producer.domain.Event;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class EventProducerStepConfiguration {
	
	private static final String STEP_NAME="EventProducerStep";
	
	private final StepBuilderFactory stepBuilderFactory;

	
	private final ItemReader<Event> eventProduceritemReader;
	
	private final PlatformTransactionManager transactionManager;
	
	
	@Bean(name = STEP_NAME)
	public Step stepConfig(CompositeItemWriter<Event> compositeItemWriter) {
		return stepBuilderFactory
			   .get(STEP_NAME)
			   .transactionManager(transactionManager)
			   .<Event,Event>chunk(4)
			   .reader(eventProduceritemReader)
			   .writer(compositeItemWriter)
			   .build();
			
	}
	
	


}
