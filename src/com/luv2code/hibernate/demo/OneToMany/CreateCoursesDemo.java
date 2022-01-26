package com.luv2code.hibernate.demo.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;

public class CreateCoursesDemo {
	
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
			
			// create some courses
			Course tempCourse1= new Course("Air Guitar - The Ultimate Guide");
			Course tempCourse2= new Course("The Pinball Masterclass");
			
			// add courses to instructor
			instructor.add(tempCourse1);
			instructor.add(tempCourse2);
			
			//save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
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
