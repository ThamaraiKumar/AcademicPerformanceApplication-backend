package com.example.course.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.course.entity.CourseEntity;
import com.example.course.repository.CourseRepo;



@Service
public class CourseService {
	
	@Autowired
	CourseRepo courseRepo;
	
	
	public void save(CourseEntity course) {
	    courseRepo.save(course);
	  }
	 
	 public Optional<CourseEntity> getCourse(int id) 
		{
			return courseRepo.findById(id);
		}
	 public Iterable<CourseEntity> read()   
	 {
		 return courseRepo.findAll();
	 }
	 public void reset(CourseEntity student) 
		{
		 courseRepo.save(student);
			System.out.println("Password Changed Successfully");
		}
	 public void deleteCourse(int id)  
	 {
		 courseRepo.deleteById(id);
	 }

}
