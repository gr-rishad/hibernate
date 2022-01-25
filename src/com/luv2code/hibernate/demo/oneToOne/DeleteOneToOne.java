package com.luv2code.hibernate.demo.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;

public class DeleteOneToOne {
	
	public static void main(String[] args) {
		
		
		// create session factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session= factory.getCurrentSession();
		
		try {
			
			// start a  transaction
			session.beginTransaction();
			
			// get transaction by primary key/ id
			int id=1;
			Instructor tempInstructor= session.get(Instructor.class, id);
			
			System.out.println("Find Instructor :" + tempInstructor);
			
			// delete instructor by key
			if(tempInstructor != null) {
				System.out.println("Deleting :"+tempInstructor);
				
				// NOTE: will also delete associate "DETAILS" object
				// because of CASECASDETYPE.ALL
				session.delete(tempInstructor);
			}
			
			// commit transaction 
			session.getTransaction().commit();
			
			System.out.println("DONE");
			
			// 
		}finally {
			factory.close();
		}
	}

}
