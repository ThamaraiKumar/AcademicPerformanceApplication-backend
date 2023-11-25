package com.example.userRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userRegistration.entity.AuthRequest;
import com.example.userRegistration.entity.UserRegister;

@Repository
public interface UserRepository extends JpaRepository<UserRegister, String> {

	public UserRegister findByEmailid(String emailid);

	public void save(AuthRequest user);
	
	public UserRegister findByemailid(String emailid);

}
