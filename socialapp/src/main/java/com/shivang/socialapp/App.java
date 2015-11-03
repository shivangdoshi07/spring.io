package com.shivang.socialapp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shivang.socialapp.model.Address;
import com.shivang.socialapp.model.Organization;
import com.shivang.socialapp.model.Person;

/**
 * Hello world!
 *
 */
public class App 
{	
	@SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
       /* Organization o = new Organization("Almedus Solutions", "Startup");
        Address a = new Address("190 Ryland Street", "San Jose", "CA", "95110");
        o.setAddress(a);
        
        Person p = new Person();
        p.setFirstname("Shivang");
        p.setLastname("Doshi");
        p.setEmail("doshi.shivang@gmail.com");
        p.setDescription("First Employee");
        p.setAddress(a);
        p.setOrg(o);
        
        
        Person p1 = new Person("Ross","Geller","ross.geller@gmail.com");
        p1.setOrg(o);
        
        p.getFriends().add(p1);
        
        session.save(p1);
        session.save(o);
        session.save(p);*/
        
        
        List<Person> employees = session.createQuery("from Person").list();
        for (Person employee1 : employees) {
            System.out.println(employee1.getFirstname() + " , ");
        }
 
        session.getTransaction().commit();
        session.close();
        
    }
}
