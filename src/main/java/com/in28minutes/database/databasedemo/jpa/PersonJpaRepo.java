package com.in28minutes.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepo {

	@PersistenceContext
	EntityManager eManager;

	public Person findById(int id) {

		return eManager.find(Person.class, id);
	}

	public Person update(Person person) {

		return eManager.merge(person);
	}

	public Person insert(Person person) {

		return eManager.merge(person);
	}

	public void deleteById(int id) {

		Person person = findById(id);
		eManager.remove(person);
	}

	public List<Person> findAll() {

		TypedQuery<Person> namedQuery = eManager.createNamedQuery("find_all_persons", Person.class);

		return namedQuery.getResultList();
	}
}
