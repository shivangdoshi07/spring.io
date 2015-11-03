package com.shivang.socialapp.dao;

import java.util.List;

import com.shivang.socialapp.model.Person;

public interface PersonDAO {
	 
    public void save(Person p);
     
    public List<Person> list();
     
}