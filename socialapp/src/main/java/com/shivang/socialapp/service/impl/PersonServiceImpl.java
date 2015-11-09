package com.shivang.socialapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shivang.socialapp.dao.PersonDAO;
import com.shivang.socialapp.model.Person;
import com.shivang.socialapp.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDAO personDAO;
	
	/**
	 * Service implementation of creating a Person
	 * @param person
	 * @return
	 */
	public Person create(Person person) {
		return personDAO.create(person);
	}

	/**
	 * Service implementation of get/reading a Person
	 * @param id
	 * @return
	 */
	public Person read(long id) {
		return personDAO.read(id);
	}

	/**
	 * Service implementation of updating a Person
	 * @param person
	 * @return
	 */
	public Person update(Person person) {
		
		Person p = personDAO.read(person.getId());
		person.setFriends(p.getFriends());
		return personDAO.update(person);
	}

	/**
	 * Service implementation of deleting/removing a Person
	 * @param id
	 * @return
	 */
	public Person delete(long id) {
		Person person = personDAO.read(id);
		if(person==null)
			return null;
		return personDAO.delete(person);
	}
	
}