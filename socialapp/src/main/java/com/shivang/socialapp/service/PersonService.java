package com.shivang.socialapp.service;

import com.shivang.socialapp.model.Person;

public interface PersonService {

	/**
	 * create a new person entry 
	 */
	public Person create(Person person);
	
	/**
	 * read person's details 
	 */
	public Person read(long id);
	
	
	/**
	 * update person's details
	 */
	public Person update(Person person);
	
	/**
	 * delete person entry
	 */
	public Person delete(long id);
}
