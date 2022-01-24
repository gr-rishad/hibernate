package com.luv2code.hibernate.dmo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	
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
		
			// start a transaction
			session.beginTransaction();
			
			
			// query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			for(Student student:theStudents) {
				System.out.println(student);
			}
			
			// query students: lastName='Doe'
			theStudents= session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			for(Student student:theStudents) {
				System.out.println("\n\n Student Which last Name is Doe: "+student);
			}
			
			// query students : lastName='Doe' OR firstName ='Daffy'
			theStudents= session.createQuery(" from Student s where s.lastName='Doe' OR s.firstName='Mary'").getResultList();
			for(Student st: theStudents) {
				System.out.println(st);
			}
			
			// query students where email LIKE 'qqluv2code.com%'
			theStudents=session.createQuery("from Student s where s.email LIKE '%mary@luv2code.com'").getResultList();
			for(Student st:theStudents) {
				System.out.println("\n \n Email With luv2code: "+st);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		}finally{
			factory.close();
		}

	}
}


