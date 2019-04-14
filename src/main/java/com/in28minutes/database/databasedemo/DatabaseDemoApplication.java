package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("\\nAll users -> {}", dao.findAll());
		logger.info("\\nUser id 10001 -> {}", dao.findById(10001));
		logger.info("\\nUser name Roman -> {}", dao.findByName("Roman"));
		logger.info("\\nDeleted -> {}", dao.deleteById(10002));
		logger.info("\\nInserted -> {}", dao.insert(new Person(10005, "Elazar", "Seal Beach", new Date())));
		logger.info("\\nUpdated -> {}", dao.update(new Person(10001, "Roman", "Frankfurt", new Date())));
	}

}
