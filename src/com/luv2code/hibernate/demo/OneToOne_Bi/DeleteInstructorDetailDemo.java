package com.luv2code.hibernate.demo.OneToOne_Bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {
	
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
			// start session
			session.beginTransaction();
			
			// get instructor detail
			int id=3;
			
			InstructorDetail instructorDetail= session.get(InstructorDetail.class, id);
			
			// print instructor detail
			System.out.println("InstrucorDetail info  :"+ instructorDetail);
			
			// print instructor info
			System.out.println("Associated Instructor Info :"+instructorDetail.getInstructor());
			
			// now lets instructor detail
			System.out.println("Deleteing Instructor Detail :"+instructorDetail);
			
			// remove the associated object reference
			// break bi-directional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
			
			// commit session
			session.getTransaction().commit();
			
			System.out.println("DONE");
			
		} finally {
			factory.close();
		}
	}
	

}
