package com.shivang.socialapp.controller;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shivang.socialapp.model.Address;
import com.shivang.socialapp.model.Organization;
import com.shivang.socialapp.service.OrganizationService;

@Controller
@RequestMapping("/org")
public class OrganizationController {
	
	@Autowired
	OrganizationService organizationService;
	
	/**
	 * create a new organization
	 * @param org
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Organization> create(@ModelAttribute Organization org, @ModelAttribute Address address){
		
		if(org.getName()==null){
			org=null;
			return new ResponseEntity<Organization>(org, HttpStatus.BAD_REQUEST);
		}
		
		if(address!=null)
			org.setAddress(address);
		
		org = organizationService.create(org);
		return new ResponseEntity<Organization>(org, HttpStatus.OK);
    }
	
	/**
	 RESTful Method
	 * get an existing organization
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Organization> getOrganization(@PathVariable long id, @RequestParam(required=false) String format){
		
		Organization org = organizationService.read(id);
		if(org==null)
			return new ResponseEntity<Organization>(org, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Organization>(org, HttpStatus.OK);
	}
	
	/**
	 * View Method
 	 * get an existing organization
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="{id}", method=RequestMethod.GET, produces={"text/html"})
	public String getOrganizationWithView(@PathVariable("id") long id, Model model){
		
		Organization org = organizationService.read(id);
		if(org==null)
			return new String("Couldn't find requested view with Error "+HttpStatus.NOT_FOUND);
		
		model.addAttribute("org",org);
		return "org";
	}	
	
	/**
	 Update an existing organization
	 * @param id
	 * @param org
	 * @param address
	 * @return
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Organization> updateOrganization(@PathVariable long id, @ModelAttribute Organization org, @ModelAttribute Address address){
				
		if(org.getName()==null){
			org=null;
			return new ResponseEntity<Organization>(org, HttpStatus.BAD_REQUEST);
		}
		
		if(address!=null)
			org.setAddress(address);

		org.setOrganization_id(id);
		
		org = organizationService.update(org);
		if(org==null)
			return new ResponseEntity<Organization>(org, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Organization>(org, HttpStatus.OK);
	}
	
	/**
	 Delete an organization
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Organization> deleteOrganization(@PathVariable long id){
		
		Organization org = null;
		try{
			org = organizationService.delete(id);
		} catch(HibernateException he){
			return new ResponseEntity<Organization>(org, HttpStatus.BAD_REQUEST);
		}
		if(org==null)
			return new ResponseEntity<Organization>(org, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Organization>(org, HttpStatus.OK);
	}

}