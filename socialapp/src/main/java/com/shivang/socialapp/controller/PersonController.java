package com.shivang.socialapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.shivang.socialapp.service.OrganizationService;
import com.shivang.socialapp.service.PersonService;


@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@Autowired
	OrganizationService organizationService;

	@RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Person> addUser(@ModelAttribute Person person, @ModelAttribute Address address, @ModelAttribute Organization organization){
		
		if(person.getFirstname()==null || person.getLastname()==null || person.getEmail()==null){
			person=null;
			return new ResponseEntity<Person>(person, HttpStatus.BAD_REQUEST);
		}
		
		if(address!=null)
			person.setAddress(address);
		
		if(organization!=null){
			organization = organizationService.read(organization.getOrganization_id());
			if(organization==null){
				person=null;
				return new ResponseEntity<Person>(person, HttpStatus.BAD_REQUEST);
			}else
				person.setOrg(organization);
		}
		
		person = personService.create(person);
		return new ResponseEntity<Person>(person, HttpStatus.OK);				
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