package com.shivang.socialapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shivang.socialapp.model.Address;
import com.shivang.socialapp.model.Organization;
import com.shivang.socialapp.model.Person;


@Controller
@RequestMapping("/person")
public class PersonController {
	
	/*@Autowired
	Person person;*/

	@RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Person create(@ModelAttribute Person person, @ModelAttribute Address address, @ModelAttribute Organization organization){
		
		System.out.println("Hiii");
		System.out.println(person.toString()+","+address.toString()+","+organization.toString());
	    return null;		
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Person getPerson(@PathVariable long id){
		
		System.out.println("Hiii");
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Person updatePerson(@PathVariable long id, @ModelAttribute Person person){

		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Person deletePerson(@PathVariable long id){
		
		return null;
	}
}