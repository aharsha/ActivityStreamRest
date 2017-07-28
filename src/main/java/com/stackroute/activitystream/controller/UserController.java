
//Author Harsha
//controller for User Module
package com.stackroute.activitystream.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.dao.UserDao;
import com.stackroute.activitystream.model.User;





@RestController
public class UserController {
	
	@Autowired
	UserDao userDAO;
	
	@Autowired
	HttpSession httpSession;
	
	//regsiter User -> if success HttpStatus.OK->if new register with existed email ->HttpStatus.CONFLICT
	@PostMapping("/addUser")
	public ResponseEntity<User> addNewUser(@RequestBody User user)
	{
		System.out.println("control at add  user ");
		try
		{//j
		boolean reisterStatus=userDAO.addUser(user);
		if(reisterStatus==true)
		{
		return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<User>(user,HttpStatus.BAD_REQUEST);
		}
		}
		catch(DataIntegrityViolationException exception )
		{
			exception.printStackTrace();
			//api for httpstatus code 
			//https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/HttpStatus.html
			return new ResponseEntity<User>(user,HttpStatus.CONFLICT);
				
		}
		catch(Exception exception )
		{
			return new ResponseEntity<User>(user,HttpStatus.BAD_REQUEST);
				
		}
		}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user)
	{
		boolean login=userDAO.validateUser(user.getEmail(),user.getPassword());
		
		if(login==true)
		{
			
			httpSession.setAttribute("login",true);
			httpSession.setAttribute("email",user.getEmail());
			
		return new ResponseEntity<String>("login success",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("login failed",HttpStatus.UNAUTHORIZED);
	}
	
	
	@GetMapping("/logout")
	public ResponseEntity<Boolean> logout()
	{
		System.out.println(httpSession.getAttribute("email"));
	     httpSession.removeAttribute("email");
	     httpSession.invalidate();
	   
	     
	     return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
	}
		

}
