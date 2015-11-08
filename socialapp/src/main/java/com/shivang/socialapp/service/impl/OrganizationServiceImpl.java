package com.shivang.socialapp.service.impl;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shivang.socialapp.dao.OrganizationDAO;
import com.shivang.socialapp.dao.PersonDAO;
import com.shivang.socialapp.model.Organization;
import com.shivang.socialapp.service.OrganizationService;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService{

	@Autowired
	PersonDAO personDAO;
	
	@Autowired
	OrganizationDAO organizationDAO;

	/**
	 * Service implementation of creating an Organization
	 */
	@Override
	public Organization create(Organization organization) {
		return organizationDAO.create(organization);
	}

	/**
	 * Service implementation of get/reading an Organization
	 */
	@Override
	public Organization read(long id) {
		return organizationDAO.read(id);
	}

	/**
	 * Service implementation of updating an Organization
	 */
	@Override
	public Organization update(Organization organization) {
		return organizationDAO.update(organization);
	}

	/**
	 * Service implementation of removing/deleting an Organization
	 */
	@Override
	public Organization delete(long id) {
		
		Organization organization = organizationDAO.read(id);
		if(organization==null)
			return null;
		if(personDAO.checkPersonInOrganization(organization)!=null)
			throw new HibernateException("Cannot delete, the Organization still has one or more person belonging to it");
		else
			return organizationDAO.delete(organization);
	}		
}