package com.luv2code.hibernate.demo.OneToOne_Bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;

public class GetInstructorDetailDemo {
	
	public static void main(String[] args) {
		
		
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session= factory.getCurrentSession();
		
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			// get the instructorDetail object
			int id=2;
			
			InstructorDetail instructorDetail= session.get(InstructorDetail.class, id);
			
			// print the instructor detail
			
			System.out.println("Instructor Detail: "+instructorDetail);
			
			// print the associated instructor
			 System.out.println("The associated Instructor: "+ instructorDetail.getInstructor());
			//commit transaction
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("DONE");
		}
		catch (Exception e) {
			// handle connection leak issue
			session.close();
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
