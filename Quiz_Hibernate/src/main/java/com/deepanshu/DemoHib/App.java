package com.deepanshu.DemoHib;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

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
		
		ArrayList<String> list1 = new ArrayList<String>();
		
		list1.add("Java is a Programming language");
		list1.add("java is a platform independent");
		
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.add("Servlet is an Interface");
		list2.add("Servlet is an API");
		
		Question q1=new Question();
		q1.setQname("What is Java");
		q1.setAnswers(list1);
		
		Question q2 = new Question();
		q2.setQname("What is Servlet");
		q2.setAnswers(list2);
		
		session.persist(q1);
		session.persist(q2);
		t.commit();
		
		System.out.println("Send data -Success ");
		
		TypedQuery query = session.createQuery("from Question");
		List<Question>list=query.getResultList();
		
		Iterator<Question>itr = list.iterator();
		while(itr.hasNext()) {
			Question q = itr.next();
			System.out.println("Question Name: "+q.getQname());
			
			List<String> list11 = q.getAnswers();
			Iterator<String> itr1 =list11.iterator();
			while(itr1.hasNext()) {
				System.out.println(itr1.next());
			}
		}
		
		
		session.close();
		System.out.println("Final Success");
		
		
		
		
	}

}
