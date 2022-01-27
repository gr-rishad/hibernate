package com.luv2code.hibernate.demo.eagerVsLazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.OneToMany.Course;
import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;


public class FetchJoinDemo {
	
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
			
			// hibernate query with HQL
			
			// get the instructor from db
			int id=1;
			
			Query<Instructor> query= session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+"where i.id=:theInstructorId",
					Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", id);
			
			// execute query and set instructor
			Instructor instructor= query.getSingleResult();
			
			System.out.println("Course Instructir :"+ instructor);
			
			//commit session
			session.getTransaction().commit();
			
			// end session
			session.close();
			
			System.out.println("DONE");
		}finally {
			
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
