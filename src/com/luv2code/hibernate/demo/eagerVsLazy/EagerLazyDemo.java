package com.luv2code.hibernate.demo.eagerVsLazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.OneToMany.Course;
import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;

public class EagerLazyDemo {
	
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
			

			// start session
			session.beginTransaction();
			
			
			// get the instructor from db
			int id=1;
			Instructor instructor= session.get(Instructor.class,id);
			
			System.out.println("Instructor :"+instructor);
			System.out.println("Courses:"+instructor.getCourses());
			
			
			//commit session
			session.getTransaction().commit();
			
			System.out.println("We are going to closed the session. \n");
			
			// end session
			session.close();
			
			// get courses for the instructor
			System.out.println("Courses:"+instructor.getCourses());
			
			System.out.println("DONE");
		}finally {
			
			// add clean up code
			session.close();
			factory.close();
		}
	}

		
	

}
