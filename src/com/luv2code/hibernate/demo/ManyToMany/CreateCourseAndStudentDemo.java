package com.luv2code.hibernate.demo.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.OneToMany.Course;
import com.luv2code.hibernate.demo.OneToMany.Review;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.oneToOne.entity.Instructor;
import com.luv2code.hibernate.demo.oneToOne.entity.InstructorDetail;

public class CreateCourseAndStudentDemo {
	
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
			
			// create a course
			Course tempCourse= new Course("Pacman - How To Score One million Points");
			
			// save the course
			System.out.println("\n Saving the course....");
			session.save(tempCourse);
			System.out.println("Saved the course...."+tempCourse);
			
			
			// Create the students
			Student tempStudent1= new Student("John","Doe","john@luv2code.com");
			Student tempStudent2= new Student("Mary","Public","mary@luv2code.com");
			
			// add student to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save the student
			System.out.println("\n Saving students ");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved Students :"+tempCourse.getStudents());
			
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
