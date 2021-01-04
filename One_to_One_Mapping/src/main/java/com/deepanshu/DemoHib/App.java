package com.deepanshu.DemoHib;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
		Employee e = new Employee();
		
		e.setName("Deepanshu");
		e.setEmail("mmail@gmail.com");
		
		Address address1 = new Address();
		address1.setAddressLine1("G-21,Lohia nagar");    
	    address1.setCity("Ghaziabad");    
	    address1.setState("UP");    
	    address1.setCountry("India");    
	    address1.setPincode(201301);  
	    
	    e.setAddress(address1);
	    address1.setEmployee(e);
        
		session.persist(e);
		
		t.commit();
		
		System.out.println("Send data -Success ");
		

		TypedQuery query = session.createQuery("from Employee");
		List<Employee> list = query.getResultList();
		
		Iterator<Employee> itr=list.iterator();
		
		while(itr.hasNext()) {
			Employee emp=itr.next();
		     System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getEmail());    
		     Address address=emp.getAddress();    
		     System.out.println(address.getAddressLine1()+" "+address.getCity()+" "+    
		        address.getState()+" "+address.getCountry()+" "+address.getPincode()); 
		     
		}
		
		session.close();
		System.out.println("Final Success");	
	}

}
