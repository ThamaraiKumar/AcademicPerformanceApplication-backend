package com.example.student.controller;

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

import com.example.student.entity.StudentEntity;
import com.example.student.service.StudentService;


@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	
	
	@Autowired
	StudentService studentService;
//	@Autowired
//	private  JwtGenerator jwtGenerator;
//	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/addStudent")
	 public String singUp(@RequestBody StudentEntity student)
	  {
		   return studentService.saveSignUp(student);
		  
	  }
	
//	@PostMapping("/register")
//    public ResponseEntity<?> postUser(@RequestBody StudentEntity student){
//		String password=student.getPassword();
//	    String hashedPassword=passwordEncoder.encode(password);
//        try{
//        	student.setPassword(hashedPassword);
//            studentService.saveSignUp(student);
//            return new ResponseEntity<>(student, HttpStatus.CREATED);
//        } catch (Exception e){
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//        }
//    }
//	 @PostMapping("/login")
//	  public ResponseEntity<?> loginUser(@RequestBody StudentEntity user) {
//	    try {
//	      if(user.getEmailid() == null || user.getPassword() == null) {
//	      throw new UserNotFoundException("UserName or Password is Empty");
//	    }
//	      
//	   StudentEntity userData = studentService.getEmailidAndPassword(user.getEmailid(), user.getPassword());
//	    if(userData == null){
//	       throw new UserNotFoundException("UserName or Password is Invalid");
//	    }
//	       return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);
//	    } catch (UserNotFoundException e) {
//	       return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//	    }
//	  }
	
	
	@GetMapping("/getstudent/{emailid}")
	public Optional<StudentEntity> getStudentIn(@PathVariable String emailid)
	{
		return studentService.getStudent(emailid);
	}
	@GetMapping("/getAllstudent")
	public Iterable<StudentEntity> getStudent()
	{
		return studentService.read();
	}
	@PutMapping("/resetpasswordStudent")
	public void changePassword(@RequestBody StudentEntity student)
	{
		studentService.resetPassword(student);
	}
	@DeleteMapping("/deleteStudent/{emailid}")
	public void remove(@PathVariable String emailid)
	{
		studentService.deleteStudent(emailid);
	}

}
