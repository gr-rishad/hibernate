package com.luv2code.hibernate.demo.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.OneToMany.Course;
import com.luv2code.hibernate.demo.OneToMany.Review;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;

public class AddCoursesForMaryDemo {
	
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
			
			// get the student mary from db
			int theId=2;
			Student student= session.get(Student.class, theId);
			
			System.out.println("\n Loaded Student :"+student);
			System.out.println("Course :"+student.getCourses());
			
			// create more courses
			Course tempCourse1= new Course("Introduction to Software Engineering");
			Course tempCourse2= new Course("Physics With Lab");
			// add student to course
			tempCourse1.addStudent(student);
			tempCourse2.addStudent(student);
			
			
			// save the courses
			System.out.println("/n Saving the course...");
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
