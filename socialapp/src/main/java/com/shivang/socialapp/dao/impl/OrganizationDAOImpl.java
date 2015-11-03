package com.shivang.socialapp.dao.impl;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shivang.socialapp.dao.OrganizationDAO;
import com.shivang.socialapp.model.Organization;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

	@Autowired
    SessionFactory sessionFactory;

	@Override
	public Organization create(Organization organization) {
		return organization;
	}

	@Override
	public Organization read(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		Organization organization = null;
		try{
			organization = (Organization) session.get(Organization.class, id);
			tx.commit();
		} catch(HibernateException h){
			tx.rollback();
		} finally{
			session.close();
		}
		return organization;
	}

	@Override
	public Organization update(Organization organization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organization delete(Organization organization) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
