package com.shivang.socialapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivang.socialapp.dao.PersonDAO;
import com.shivang.socialapp.model.Person;
import com.shivang.socialapp.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDAO personDAO;
	
	/**
	 * 
	 * @param person
	 * @return
	 */
	public Person create(Person person) {
		return personDAO.create(person);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Person read(long id) {
		return personDAO.read(id);
	}

	/**
	 * 
	 * @param person
	 * @return
	 */
	public Person update(Person person) {
		return personDAO.update(person);
	}

	/**
	 * 
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