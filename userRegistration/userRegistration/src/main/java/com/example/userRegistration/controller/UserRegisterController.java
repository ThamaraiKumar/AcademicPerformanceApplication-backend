package com.example.userRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userRegistration.entity.AuthRequest;
import com.example.userRegistration.entity.AuthResponse;
import com.example.userRegistration.entity.UserRegister;
import com.example.userRegistration.exception.UserNotFoundException;
import com.example.userRegistration.jwt.JwtGenerator;
import com.example.userRegistration.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UserRegisterController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@PostMapping("/register")
	public ResponseEntity<?> postUser(@RequestBody UserRegister user){
		 String password=user.getPassword();
		 String hashedPassword=passwordEncoder.encode(password);
	        try{
	        	user.setPassword(hashedPassword);
	            userService.saveRegister(user);
	            return new ResponseEntity<>(user, HttpStatus.CREATED);
	        } catch (Exception e){
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	        }
	    }
	
//	 @PostMapping("/login")
//	  public ResponseEntity<?> loginUser(@RequestBody AuthRequest request) {
//	    try {
//	      if(request.getEmailid() == null || request.getPassword() == null) {
//	      throw new UserNotFoundException("UserName or Password is Empty");
//	    }
//	      
//	   AuthRequest userData = userService.getEmailidAndPassword(request.getEmailid(), request.getPassword());
//	    if(userData == null){
//	       throw new UserNotFoundException("UserName or Password is Invalid");
//	    }
//	       return new ResponseEntity<>(jwtGenerator.generateToken(request), HttpStatus.OK);
//	    } catch (UserNotFoundException e) {
//	       return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//	    }
//	  }
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody AuthRequest request) {
	    try {
	        if (request.getEmailid() == null || request.getPassword() == null) {
	            throw new UserNotFoundException("UserName or Password is Empty");
	        }
	        UserRegister userData = userService.getEmailidAndPassword(request.getEmailid(), request.getPassword());
	        if (userData == null) {
	            throw new UserNotFoundException("UserName or Password is Invalid");
	        }
	        String token = jwtGenerator.generateToken(request);
	        String role = userService.getRoleForUser(request.getEmailid());
	        AuthResponse response = AuthResponse.builder()
	            .token(token)
	            .emailid(userData.getEmailid())
	            .role(role)
	            .build();
	        return ResponseEntity.ok(response);
	    } catch (UserNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	    }
	}
	
	
	  
	
	
	
	 
	 @PutMapping("/updatepassword")
	 public void updatePassword(@RequestBody AuthRequest request)
	 {
		 userService.updatePassword(request.getEmailid(),request.getPassword());
	 }
	 
//	 @PutMapping("/updatepassword")
//	 public ResponseEntity<?> updatePassword(@RequestBody AuthRequest request) {
//	     try {
//	         userService.updatePassword(request.getEmailid(), request.getPassword());
//	         return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
//	     } catch (Exception e) {
//	         return new ResponseEntity<>("An error occurred while updating the password", HttpStatus.INTERNAL_SERVER_ERROR);
//	     }
//	 }

}
