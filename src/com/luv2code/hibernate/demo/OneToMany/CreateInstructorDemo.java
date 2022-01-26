package com.luv2code.hibernate.demo.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;

public class CreateInstructorDemo {
	
	public static void main(String[] args) {
		
		
		// create session factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session= factory.getCurrentSession();
		
		try {
			
			// create the object
			Instructor tempInstructor= new Instructor("Susan","Public","susan.public@luv2code.com");
			
			InstructorDetail detail= new InstructorDetail("http://youtube.com","Watching TV");
			
			// associate the objects
			tempInstructor.setInstructorDetail(detail);
			
			// start session
			session.beginTransaction();
			
			//save the instructor
			System.out.println("Saving Instructor :"+tempInstructor);
			session.save(tempInstructor);
			
			
			//commit session
			session.getTransaction().commit();
			
			System.out.println("DONE");
		}finally {
			
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
