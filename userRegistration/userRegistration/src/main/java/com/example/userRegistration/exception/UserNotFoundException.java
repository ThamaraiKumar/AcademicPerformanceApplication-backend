package com.example.userRegistration.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	
	 @SuppressWarnings("unused")
	private String message;

	    public UserNotFoundException(String message){
	        super(message);
	        this.message=message;
	    }

	    public UserNotFoundException() {}
	
	
	

}
