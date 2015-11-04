package com.shivang.socialapp.service;

import com.shivang.socialapp.model.Organization;

public interface OrganizationService {

	/**
	 * create new organization
	 */
	public Organization create(Organization organization);
	
	/**
	 * read organization details 
	 */
	public Organization read(long id);
	
	
	/**
	 * update organization details
	 */
	public Organization update(Organization organization);
	
	/**
	 * delete the organization
	 */
	public Organization delete(long id);

}
