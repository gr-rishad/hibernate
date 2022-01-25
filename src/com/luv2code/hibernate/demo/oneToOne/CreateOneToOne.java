package com.luv2code.hibernate.demo.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;


public class CreateOneToOne {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory=  new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session= factory.getCurrentSession();
		
		try {
			
			// create the objects
			Instructor instructor = new Instructor("Golam","Rabbani","rishad@luv2code.com");		
			InstructorDetail detail= new InstructorDetail("http://www.fb.com/youtube","Cricket !!");
			
			// 2nd object
			//Instructor instructor = new Instructor("Shah","Alam","alam@luv2code.com");		
			//InstructorDetail detail= new InstructorDetail("http://www.twitter.com/alam","Football");
						
					
			//associate the objects
			instructor.setInstructorDetail(detail);
						
						
			// start a transaction
			session.beginTransaction();
			
			// save 
			System.out.println("saving instructor : "+instructor);
			session.save(instructor);
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done !!");
			
		} finally {
			factory.close();
		} 
		
	}

}
