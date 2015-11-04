package com.shivang.socialapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/**
	 POST request to add an person
	 * @param person
	 * @param address
	 * @param organization
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Person> addPerson(@ModelAttribute Person person, @ModelAttribute Address address, @ModelAttribute Organization organization){
		
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
	
	/**
	 GET request to get a specific person by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Person> getPerson(@PathVariable("id") long id, @RequestParam(required=false) String format){
		
		Person person = personService.read(id);
		if(person==null)
			return new ResponseEntity<Person>(person, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	/**
	 POST request to update an existing person
	 * @param id
	 * @param person
	 * @param address
	 * @param organization
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Person> updatePerson(@PathVariable long id, @ModelAttribute Person person, @ModelAttribute Address address, @ModelAttribute Organization organization){

		person.setId(id);

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
		
		person = personService.update(person);
		if(person==null)
			return new ResponseEntity<Person>(person, HttpStatus.NOT_FOUND);

		return new ResponseEntity<Person>(person, HttpStatus.OK);		
	}
	
	/**
	 DELETE request to delete an specific person by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Person> deletePerson(@PathVariable long id){
		
		Person person = personService.delete(id);
		if(person==null)
			return new ResponseEntity<Person>(person, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

}