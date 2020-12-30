package com.deepanshu.DemoHib;


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
		Transaction t= session.beginTransaction();
		
		Employee e =new Employee();
		e.setId(101);
		e.setFirstName("Deepanshu");
		e.setLastName("Chauhan");
		
		session.save(e);
		t.commit();
		System.out.println("Successfully saved!!");
		factory.close();
		session.close();
	}

}
