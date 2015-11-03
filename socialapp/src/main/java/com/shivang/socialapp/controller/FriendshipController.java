package com.shivang.socialapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/friends/{id1}/{id2}")
public class FriendshipController {

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String addFriend(@PathVariable long id1, @PathVariable long id2){
		
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public String removeFriend(@PathVariable long id1, @PathVariable long id2){
		
		return null;
	}

}
