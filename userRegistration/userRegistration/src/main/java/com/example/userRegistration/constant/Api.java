package com.example.userRegistration.constant;

import java.util.Arrays;
import java.util.List;

public class Api {
	
	public static final String DEFAULT="http://localhost:8080";
	public static final String ADMIN="/admin";
	public static final String STAFF="/staff";
	public static final String STUDENT="/student";
	
	public static final List<String> HEADERS=Arrays.asList("Authorization","Content-Type");
	public static final List<String> METHODS=Arrays.asList("GET","POST","PUT","DELETE");
	public static final List<String> ORIGINS=Arrays.asList("http://localhost:3000");

}
