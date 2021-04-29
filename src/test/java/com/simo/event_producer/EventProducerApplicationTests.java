package com.simo.event_producer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class EventProducerApplicationTests {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	

	@Test
	void contextLoads() {
	}
	
	@Test
	public void Call_COUNT_SHOULD_RETURN_4() {
		int number_rows = jdbcTemplate.queryForObject("select count(*) from event",Integer.class);
		assertEquals(3, number_rows);
	}

	
	@Test
	public void SHOULD_CREATE_RESULT_FILE_WITH_CONTENT_OF_EVENT_TABLE() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		jobLauncher.run(job, new JobParametersBuilder().addString("date-time", LocalDate.now().toString()).toJobParameters());
	}
}
