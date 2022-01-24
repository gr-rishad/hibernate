package com.luv2code.hibernate.dmo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	
	public static void main(String[] args) {
		
		// Create Session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			
			// new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id : primary key
			int studentId= 8;
			System.out.println("\n Getting student with :"+studentId);
			
			Student student= session.get(Student.class, studentId);
			session.delete(student);
			session.getTransaction().commit();
			
			// get Student list
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Student> myStudents= session.createQuery("from Student").getResultList();
			for(Student st: myStudents) {
				System.out.println(st);
			}
			
			System.out.println("Done");
			
		}finally{
			factory.close();
			}
	}

}
