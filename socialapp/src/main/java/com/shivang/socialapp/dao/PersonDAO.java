package com.shivang.socialapp.dao;

import java.util.List;

import com.shivang.socialapp.model.Person;

public interface PersonDAO {
	 
    /**
     * create a new person
     * @param person
     * @return
     */
	public Person create(Person person);
    
	/**
	 * get a person details
	 * @param person
	 * @return
	 */
    public Person read(long id);
    
    /**
     * update person's details
     * @param person
     * @return
     */
    public Person update(Person person);	
    
    /**
     * delete person entry
     * @param person
     * @return
     */
    public Person delete(Person person);
}