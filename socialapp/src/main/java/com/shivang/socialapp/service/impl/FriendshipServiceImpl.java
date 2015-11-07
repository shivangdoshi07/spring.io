package com.shivang.socialapp.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shivang.socialapp.dao.PersonDAO;
import com.shivang.socialapp.model.Person;
import com.shivang.socialapp.service.FriendshipService;

@Service
@Transactional
public class FriendshipServiceImpl implements FriendshipService {

	@Autowired
	PersonDAO personDAO;
	
	@Override
	public Person create(long id1, long id2) {
		
		Person person1 = personDAO.read(id1);	
		Person person2 = personDAO.read(id2);
		
		if(person1 == null || person2 == null)
			return null;
		boolean count = false;
		
		Iterator iterator = person1.getFriends().iterator();
		while(iterator.hasNext()){	
			Person p = (Person) iterator.next();
			if(p.getId()==id2){
				count=true;
				break;
			}		
		}
		
		if(!count){
			iterator = person2.getFriends().iterator();
			while(iterator.hasNext()){	
				Person p = (Person) iterator.next();
				if(p.getId()==id1){
					count=true;
					break;
				}		
			}
		}
		
		if(count)
			return person1;
		else{
			person1.getFriends().add(person2);
			return personDAO.update(person1);
		}
	}

	@Override
	public Person delete(long id1, long id2) {
		Person person1 = personDAO.read(id1);	
		Person person2 = personDAO.read(id2);
		
		if(person1 == null || person2 == null)
			return null;
		
		boolean count = false;
		Iterator iterator = person1.getFriends().iterator();
		
		while(iterator.hasNext()){	
			Person p = (Person) iterator.next();
			if(p.getId()==id2){
				iterator.remove();
				count = true;
				break;
			}		
		}
		Person person = person1;
		
		if(!count){			
			iterator = person2.getFriends().iterator();
			
			while(iterator.hasNext()){
				Person p = (Person) iterator.next();
				if(p.getId()==id1){
					iterator.remove();
					count = true;
					break;
				}		
			}
			person = person2;
		}

		if(!count)
			return null;
		
		return personDAO.update(person);
	}
}
