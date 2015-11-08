package com.shivang.socialapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shivang.socialapp.model.Person;
import com.shivang.socialapp.service.FriendshipService;

@Controller
@RequestMapping("/friends/{id1}/{id2}")
public class FriendshipController {

	@Autowired
	FriendshipService friendshipService;
	
	/**
	 * Record friendship of Person with two given id's if they exist
	 * @param id1
	 * @param id2
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> addFriend(@PathVariable long id1, @PathVariable long id2){
		
		Person person = friendshipService.create(id1, id2);
		if(person==null)
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<String>("Success, Person with id's "+id1+" and "+id2+" are friends.", HttpStatus.OK);		
	}
	
	/**
	 * Delete/Remove a friendship between 2 persons if they are friends
	 * @param id1
	 * @param id2
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> removeFriend(@PathVariable long id1, @PathVariable long id2){
		
		Person person = friendshipService.delete(id1, id2);
		if(person==null)
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<String>("Success, Person with id's "+id1+"and "+id2+" are no more friends.", HttpStatus.OK);
	}

}