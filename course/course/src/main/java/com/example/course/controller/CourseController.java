package com.example.course.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entity.CourseEntity;
import com.example.course.service.CourseService;

@RestController
@CrossOrigin
@RequestMapping("/Astaff")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping("/addCourse")
	 public void save(@RequestBody CourseEntity course)
	  {
     	   courseService.save(course);  
	  }
	@GetMapping("/getCourse/{id}")
	public Optional<CourseEntity> getStudentIn(@PathVariable int id)
	{
		return courseService.getCourse(id);
	}
	@GetMapping("/getAllCourse")
	public Iterable<CourseEntity> get()
	{
		return courseService.read();
	}
	@PutMapping("/resetpasswordStudent")
	public void changePassword(@RequestBody CourseEntity course)
	{
		courseService.reset(course);
	}
	@DeleteMapping("/deletecourse/{id}")
	public void remove(@PathVariable int id)
	{
		courseService.deleteCourse(id);
	}
	

}
