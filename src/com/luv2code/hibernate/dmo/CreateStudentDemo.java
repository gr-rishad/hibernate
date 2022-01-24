package com.luv2code.hibernate.dmo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create Session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// use session object to save Java Object
			
			
			// create a student object
			System.out.println("Creating new student object.....");
			Student tempStudent= new Student("Paul","Wall","paul@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student.....");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		}finally{
			factory.close();
		}

	}

}
