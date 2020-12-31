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
		e.setName("Deepanshu Chauhan");
		
		Contract_Employee c = new Contract_Employee();
		c.setName("Ravi");
		c.setContract_duration("1000");
		c.setPay_per_hour(12);
		
		Regular_Employee r = new Regular_Employee();
		r.setName("Vikas");
		r.setSalary(5000);
		r.setBonus(100);
		
		
		session.persist(e);
		session.persist(c);
		session.persist(r);
		t.commit();
		System.out.println("Successfully saved!!");
		factory.close();
		session.close();
	}

}
