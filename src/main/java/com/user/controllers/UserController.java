package com.user.controllers;

import java.math.BigInteger;
 
import java.security.SecureRandom;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.user.dao.UserDAO;
import com.user.model.User;
import com.user.response.Response;
 
 

@RestController
public class UserController {

	 
	
	@Autowired
	private UserDAO userDAO;
	
 

	 @RequestMapping(value = "/verification_code/{user_id}", method = RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE, 
             MediaType.APPLICATION_XML_VALUE})
	public    Response    generateVerificationCode(@PathVariable("user_id") int id) {
		 Response response=new Response();
		 
		try {
			System.out.println("User ID"+id);
			System.out.println("userDAO"+userDAO);
			User user = userDAO.findById(id).get();
			
			 
	 			if (user == null) {
	 				System.out.println("There Is Not User ID ");
	 				response.setResult_code(0);
	 				response.setMessage("error");
	 				return  response ;
				}
				String verfivationCode=generateVerficationCode();
				System.out.println(verfivationCode);
			 	user.setVerification_code(verfivationCode);
				userDAO.save(user);
				response.setResult_code(1);
				response.setMessage("successful");
				
				return  response;
			  

		} catch (Exception ex) {
			    response.setResult_code(0);
				response.setMessage("error");
				return  response ;
		}
	} 
	 
	 public String generateVerficationCode() {
 
		 
		  SecureRandom secureRandom = new SecureRandom();
		    byte[] token = new byte[3];
		    secureRandom.nextBytes(token);
		    return new BigInteger(1, token).toString(16); //hex encoding
		    
	 }
	
	@RequestMapping(value = "/verification_code/{id}/{code}", method = RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE, 
            MediaType.APPLICATION_XML_VALUE,"application/csv"})
	public   Response   getById(@PathVariable("id") int id,@PathVariable("code") String code ) {
		Response response=new Response();
		 
		try {
			User user = userDAO.findById(id).get();
         if (user == null) {
				response.setResult_code(0);
				response.setValid("");
				return  response;
				 
			}
			if(user.getVerification_code().equals(code))
			{
				response.setResult_code(1);
				response.setValid("true");
			}else
			{
				response.setResult_code(1);
				response.setValid("false");
				
			}
			
			  return response ;
			 

		} catch (Exception ex) {
			response.setResult_code(0);
			response.setValid("");
			response.setMessage("error");
			return response;
		}
	} 
}