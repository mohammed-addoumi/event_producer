package com.simo.event_producer.batch.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.simo.event_producer.domain.Event;

public class EventProducerRowMapper implements RowMapper<Event>{

	@Override
	public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
		Event event = new Event();
		event.setId(rs.getInt("id"));
		event.setName(rs.getString("name"));
		event.setEvent_type(rs.getString("event_type"));
		event.setStatus(rs.getString("status"));
		return event;
	}

}
