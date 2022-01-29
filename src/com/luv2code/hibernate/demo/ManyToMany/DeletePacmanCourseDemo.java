package com.luv2code.hibernate.demo.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.OneToMany.Course;
import com.luv2code.hibernate.demo.OneToMany.Review;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;

public class DeletePacmanCourseDemo {
	
	public static void main(String[] args) {
		

		// create session factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session= factory.getCurrentSession();
		
		try {
			

			// start session
			session.beginTransaction();
			
			// get the pacman course from db
			int courseId=10;
			Course course= session.get(Course.class, courseId);
			
			
			// delete the course 
			System.out.println("Deleting course:"+course);
			session.delete(course);
	
			
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
