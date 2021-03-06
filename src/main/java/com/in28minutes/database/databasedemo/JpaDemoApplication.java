package com.in28minutes.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepo;

//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("\nUser id 10001 -> {}", repo.findById(10001));
		logger.info("\\nInserted -> {}", repo.insert(new Person("Elazar", "Seal Beach", new Date())));
		logger.info("\\nUpdated -> {}", repo.update(new Person(10003, "Elmira", "Frankfurt", new Date())));
		repo.deleteById(10002);
		logger.info("\\nAll users -> {}", repo.findAll());

//		logger.info("\\nUser name Roman -> {}", repo.findByName("Roman"));
//		

	}

}
