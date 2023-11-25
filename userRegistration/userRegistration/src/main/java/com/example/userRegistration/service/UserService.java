package com.example.userRegistration.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userRegistration.entity.AuthRequest;
import com.example.userRegistration.entity.AuthResponse;
import com.example.userRegistration.entity.UserRegister;
import com.example.userRegistration.exception.UserNotFoundException;
import com.example.userRegistration.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public void saveRegister(UserRegister user)
	{
		userRepo.save(user);
	}
	
	public void updatePassword(String emailid,String newPassword)
	{
		UserRegister user=userRepo.findByemailid(emailid);
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		if(user!=null)
		{
			String hashedPassword=passwordEncoder.encode(newPassword);
			user.setPassword(hashedPassword);
			userRepo.save(user);
		}
	}
	public Iterable<UserRegister> getRegisteredUsers()
	{
		return userRepo.findAll();
	}
	public void deleteUser(String emailid)
	{
		userRepo.deleteById(emailid);
	}

	public UserRegister getEmailidAndPassword(String emailid, String plainPassword) throws UserNotFoundException {
	     UserRegister user = userRepo.findByEmailid(emailid);
	    BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	    String hashedPassword=user.getPassword();
	    boolean exists=passwordEncoder.matches(plainPassword,hashedPassword);
	    if(exists)
	    {
	    	return user;
	    }
	    else
	    {
	    	throw new UserNotFoundException("Invalid id and password");
	    }

}
	
	@Value("${jwt.secret}")
    private String secret;
	BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	public AuthResponse loginUser(String emailid, String password) throws UserNotFoundException {
        UserRegister user = userRepo.findByemailid(emailid);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            UserDetails userDetails = new User(emailid, user.getPassword(), new ArrayList<>());
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            String role = user.getRole().name();

            String token = Jwts.builder()
                .setSubject(user.getEmailid())
                .claim("role", role) 
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

            return AuthResponse.builder()
                .token(token)
                .emailid(emailid)
                .role(role)
                .build();
        } else {
            throw new UserNotFoundException("Invalid email and password");
        }
    }
	public String getRoleForUser(String emailid) throws UserNotFoundException {
        UserRegister user = userRepo.findByemailid(emailid);
        if (user != null) {
            return user.getRole().name(); // Retrieve and return the user's role
        } else {
            throw new UserNotFoundException("User not found for email: " + emailid);
        }
    }
	
	

}
