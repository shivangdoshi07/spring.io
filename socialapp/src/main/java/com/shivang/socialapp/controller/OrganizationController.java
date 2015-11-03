package com.shivang.socialapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shivang.socialapp.model.Organization;

@Controller
@RequestMapping("/org")
public class OrganizationController {

	@RequestMapping( method = RequestMethod.POST )
    @ResponseBody
    public Organization create(@ModelAttribute Organization org){
		
	    return null;		
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Organization getOrganization(@PathVariable long id){
		
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Organization updateOrganization(@PathVariable long id, @ModelAttribute Organization org){
		
		return null;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Organization deleteOrganization(@PathVariable long id){
		
		return null;
	}

}