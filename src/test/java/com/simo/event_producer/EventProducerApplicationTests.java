package com.simo.event_producer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class EventProducerApplicationTests {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Test
	void contextLoads() {
	}
	
	@Test
	public void Call_COUNT_SHOULD_RETURN_4() {
		int number_rows = jdbcTemplate.queryForObject("select count(*) from event",Integer.class);
		assertEquals(3, number_rows);
	}

}
