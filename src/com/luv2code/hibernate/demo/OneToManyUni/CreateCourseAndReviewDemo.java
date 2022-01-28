package com.luv2code.hibernate.demo.OneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.OneToMany.Course;
import com.luv2code.hibernate.demo.OneToMany.Review;
import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;

public class CreateCourseAndReviewDemo {
	
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
			

			// create a course
			Course course= new Course("Pacman - How To Score One Million Points");
			
			// add some reviews
			course.addReview(new Review("Great Course... loved it!"));
			course.addReview(new Review("Cool Course, job well done !"));
			course.addReview(new Review("What a dumb course,you are an idot!"));
			course.addReview(new Review("Fantastic Course... loved it from bottom of heart!"));
			
			// save the course .... and leverage the cascade all :-)
			System.out.println("Saving the course");
			System.out.println(course);
			System.out.println(course.getReviews());
			session.save(course);
			
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
