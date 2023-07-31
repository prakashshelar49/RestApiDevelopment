package com.student.Intern.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.Intern.Model.Student;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory sf;
	Student st;
	
	public List<Student> getallStudentInfo() {
	
		
			Session session=sf.openSession();
			Criteria criteria=session.createCriteria(Student.class);
			List<Student>student=criteria.list();
			
			session.close();
			return student;
		}

	public boolean insertStudentInfo(Student student) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(student);

		transaction.commit();
		session.close();
		return true;
	}
	
	public int deleteStudentInfo(int id) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		st=session.load(Student.class, id);
		session.delete(st);
 
		transaction.commit();
		session.close();
		return id;
		
	}

	public boolean updateStudentInfo(Student student) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(student);

		transaction.commit();
		session.close();
		return true;
		
	}

	



}
