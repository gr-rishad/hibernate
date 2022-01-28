package com.luv2code.hibernate.demo.OneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.OneToMany.Course;
import com.luv2code.hibernate.demo.OneToMany.Review;
import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;

public class DeleteCourseAndReviewDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// create session
		Session session= factory.getCurrentSession();
		
		try {
		
			
			// start session
			session.beginTransaction();
			
			//get the course
			int theId= 10;
			Course tempCourse= session.get(Course.class, theId);
			
			//print the course
			System.out.println("Delete the course:.....");
			System.out.println("Course Name :"+tempCourse);
			
			//print the course reviews
			System.out.println("Course Reviews :"+tempCourse.getReviews());
			
			// delete the course
			session.delete(tempCourse);
			
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
