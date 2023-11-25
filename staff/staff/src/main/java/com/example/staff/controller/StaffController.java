package com.example.staff.controller;

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

import com.example.staff.entity.StaffEntity;
import com.example.staff.service.StaffService;

@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {
	
		@Autowired
		StaffService staffService;
		
		@PostMapping("/addStaff")
		 public String singUp(@RequestBody StaffEntity staff)
		  {
			   return staffService.saveSignUp(staff);
			  
		  }
		@GetMapping("/getstaff/{emailid}")
		public Optional<StaffEntity> getStudentIn(@PathVariable String emailid)
		{
			return staffService.getStudent(emailid);
		}
		@GetMapping("/getAllstaff")
		public Iterable<StaffEntity> getStudent()
		{
			return staffService.read();
		}
		@PutMapping("/resetpasswordStaff/{emailid}")
		public void changePassword(@RequestBody StaffEntity staff ,@PathVariable String emailid)
		{
			staffService.resetPassword(staff);
		}
		@DeleteMapping("/deleteStaff/{emailid}")
		public void remove(@PathVariable String emailid)
		{
			staffService.deleteStudent(emailid);
		}

}
