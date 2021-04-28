package com.simo.event_producer.batch.job;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class EventProducerJobConfiguration {
	
	private final static String JOB_NAME = "EventProducerJob";
	
	private final JobBuilderFactory jobBuilderFactory;
	
	private final Step step;
	
	@Bean(name = JOB_NAME)
	public Job jobConfig() {
		return jobBuilderFactory
			   .get(JOB_NAME)
			   .incrementer(new RunIdIncrementer())
			   .start(step)
			   .build();
	}
	

}
