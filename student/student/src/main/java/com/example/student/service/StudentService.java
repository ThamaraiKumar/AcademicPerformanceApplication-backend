package com.example.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.student.entity.StudentEntity;

import com.example.student.repository.StudentRepository;



@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	
	 
	  public void saveUser(StudentEntity admin) {
	    studentRepo.save(admin);
	  }
//	  public StudentEntity getEmailidAndPassword(String name, String plainPassword) throws UserNotFoundException {
//	    StudentEntity user = studentRepo.findByEmailid(name);
//	    BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
//	    String hashedPassword=user.getPassword();
//	    boolean exists=passwordEncoder.matches(plainPassword,hashedPassword);
//	    if(exists)
//	    {
//	    	return user;
//	    }
//	    else
//	    {
//	    	throw new UserNotFoundException("Invalid id and password");
//	    }
//	  }
	  
	  public String saveSignUp(StudentEntity student)   //register student
	  {
		 studentRepo.save(student);
		  return "Thanks for signUp";
	  }
	 
	 public Optional<StudentEntity> getStudent(String emailid) //login of student and also get particular student
		{
			return studentRepo.findById(emailid);
		}
	 public Iterable<StudentEntity> read()   //get all student details
	 {
		 return studentRepo.findAll();
	 }
	 public void resetPassword(StudentEntity student) //reset password
		{
			studentRepo.save(student);
			System.out.println("Password Changed Successfully");
		}
	 public void deleteStudent(String emailid)   //remove student
	 {
		 studentRepo.deleteById(emailid);
	 }

}
