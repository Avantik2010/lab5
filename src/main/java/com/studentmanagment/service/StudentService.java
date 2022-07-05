package com.studentmanagment.service;

import java.util.List;

	
	public interface StudentService {
		public List<student> findALL();
		
		public student findById (int theId);
		 public void save (student thestudent) ;
		 public void deleteById (int theId);
		
	}


