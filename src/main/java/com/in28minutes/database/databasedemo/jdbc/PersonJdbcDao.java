package com.in28minutes.database.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * SELECt * FROM person
	 */
	public List<Person> findAll() {

		return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<Person>(Person.class));
	}

	public Person findById(int id) {

		return jdbcTemplate.queryForObject("SELECT * FROM person WHERE id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public List<Person> findByName(String name) {

		return jdbcTemplate.query("SELECT * FROM person WHERE name=?", new Object[] { name },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {

		return jdbcTemplate.update("DELETE FROM person WHERE id=?", new Object[] { id });
	}
}
