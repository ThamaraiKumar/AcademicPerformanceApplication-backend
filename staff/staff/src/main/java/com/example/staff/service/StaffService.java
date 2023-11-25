package com.example.staff.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.staff.entity.StaffEntity;
import com.example.staff.repository.StaffRepository;

import org.springframework.stereotype.Service;

@Service
public class StaffService {
	
	
	@Autowired
	StaffRepository staffRepo;
	
	 
	  public void saveUser(StaffEntity staff) {
		  staffRepo.save(staff);
	  }
	  
	  public String saveSignUp(StaffEntity staff)   //register student
	  {
		  staffRepo.save(staff);
		  return "Thanks for signUp";
	  }
	 
	 public Optional<StaffEntity> getStudent(String emailid) //login of student and also get particular student
		{
			return staffRepo.findById(emailid);
		}
	 public Iterable<StaffEntity> read()   //get all student details
	 {
		 return staffRepo.findAll();
	 }
	 public void resetPassword(StaffEntity staff) //reset password
		{
		 staffRepo.save(staff);
			System.out.println("Password Changed Successfully");
		}
	 public void deleteStudent(String emailid)   //remove student
	 {
		 staffRepo.deleteById(emailid);
	 }


}
