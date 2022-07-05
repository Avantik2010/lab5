package com.studentmanagment.service;

import java.util.List;
import javax.transaction.Transactional;
import com.studentmanagment.entity.student;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Respository

public class StudentServiceImpl implements StudentService {
	
	private SessionFactory sessionFactory;
	
	private Session session;
	
@Autowired

StudentServiceImpl(SessionFactory sessionFactory) {
	this.sessionFactory =sessionFactory;
	 try {
		 session = sessionFactory.getCurrentSession();	 
	 } catch (HibernateException e) {
		 session =sessionFactory .openSession();
	 }
}
 
  @Transactional 
  
  public List<student> findAll () {
	  
	  Transaction tx =session.beginTransaction();
	  
	  List<student> students = session.createQuery("from Student").list();
	  
	  tx.commit ();
	  
	  return students;
	  
  }
  
  @Transactional
  
  public student findById(int id) {
	  student student = new student();
	  Transaction tx =session.beginTransaction();
	  student = session.get(student.class,id);
	  tx. commit();
	  return student;
  }

@Transactional

public void save (student theStudent) {
	
	Transaction tx = session. beginTransaction();
	
	session.saveOrUpdate(theStudent);
	tx.commit ();
}


@Transactional

public void deleteById(int id) {
	Transaction tx =session.beginTransaction();
	
	student student =session.get (student.class , id);
	
	session.delete(student);
	
	tx.commit();
	
}
}
