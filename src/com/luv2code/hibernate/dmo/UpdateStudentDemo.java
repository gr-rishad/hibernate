package com.luv2code.hibernate.dmo;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	
	public static void main(String[] args) {
		
		// Create Session factory
				SessionFactory factory=new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
				
				// Create Session
				Session session = factory.getCurrentSession();
				
				try {
					
					// get a new session and start transaction
					session= factory.getCurrentSession();
					session.beginTransaction();
					
					// retrieve student based on the primary key
					int studentId=6;
					System.out.println("\n Getting student with id : "+studentId);
					
					Student student= session.get(Student.class, studentId);
					student.setFirstName("Md. Shah Golam Rabbani ");
					
					System.out.println("Get completed:"+student);
					
					
					// update all student email
					
					System.out.println("Update email for all students");
				 session.createQuery("update Student set email ='foo@gmail.com'").executeUpdate();
					
					// commit the transaction
					session.getTransaction().commit();
					System.out.println("Done");
				}finally {
					factory.close();
				}
		
	}

}
