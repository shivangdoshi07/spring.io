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

	/**
	 * DAO implementation of creating an Organization
	 */
	@Override
	public Organization create(Organization org) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{
			session.save(org);
			tx.commit();
		} catch(HibernateException h) {
			tx.rollback();
		} finally {
			session.close();
		}
		return org;
	}

	/**
	 * DAO implementation of get/reading an Organization
	 */
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

	/**
	 * DAO implementation of updating an Organization
	 */
	@Override
	public Organization update(Organization org) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{
			session.update(org);
			tx.commit();
		} catch(HibernateException h) {
			tx.rollback();
			org = null;
		} finally {
			session.close();
		}
		return org;
	}

	/**
	 * DAO implementation of deleting/removing an Organization
	 */
	@Override
	public Organization delete(Organization org) {
		Session session = sessionFactory.openSession();
		Transaction tx =  session.beginTransaction();
		try{
			session.delete(org);
			tx.commit();
		} catch(HibernateException h) {
			tx.rollback();
			org = null;
		} finally {
			session.close();
		}
		return org;
	}
	
}