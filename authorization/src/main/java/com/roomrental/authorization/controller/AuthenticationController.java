package com.roomrental.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.roomrental.authorization.config.JwtUtil;
import com.roomrental.authorization.model.AuthenticationRequest;
import com.roomrental.authorization.model.AuthenticationResponse;
import com.roomrental.authorization.model.DAOUser;
import com.roomrental.authorization.model.UserDTO;
import com.roomrental.authorization.service.CustomUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/adminauthenticate")
	public ResponseEntity<?> createOwnerAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		
		UserDetails userdetails = authenticate(authenticationRequest);
		
		if(userdetails.getAuthorities().toString().substring(1, 11).equals("ROLE_ADMIN"))
		{
			System.out.println("Success");
			String token = jwtUtil.generateToken(userdetails);
			return ResponseEntity.ok(new AuthenticationResponse(token));			
		}	
		System.out.println("ROLE "+userdetails.getAuthorities().toString().substring(1, 11));
		return new ResponseEntity<>("Admin Login Permission Not Allowed",HttpStatus.BAD_REQUEST);
	}
	
	
	
	@PostMapping("/userauthenticate")
	public ResponseEntity<?> createUserAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		UserDetails userdetails = authenticate(authenticationRequest);
		
		if(userdetails.getAuthorities().toString().substring(1, 10).equals("ROLE_USER"))
		{
			System.out.println("Success");
			String token = jwtUtil.generateToken(userdetails);
			return ResponseEntity.ok(new AuthenticationResponse(token));			
		}	
		return new ResponseEntity<>("User Login Permission Not Allowed",HttpStatus.BAD_REQUEST);
	}
	
	private UserDetails authenticate(AuthenticationRequest authenticationRequest) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		return userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	}
	
	
	public ResponseEntity<?> validate(@RequestHeader("Authorization") String tokenHeader) throws Exception
	{
		System.out.println("Auth Header: " + tokenHeader);
		
		String username = null;
		String jwtToken = null;
		
		//Jwt Token is in form of Bearer String. Remove Bearer word & get only Token.
		if(tokenHeader!=null && tokenHeader.startsWith("Bearer ") )
			{	
				jwtToken = tokenHeader.substring(7);
		  		try {
		   			username = jwtUtil.getUsernameFromToken(jwtToken);
		   			}
		  		catch(IllegalArgumentException e) { 
		  			throw new IllegalArgumentException("Unable To get JWT Token");}
				catch(ExpiredJwtException e) {
		  			throw new Exception("JWT Token has expired");}
		  		catch(Exception e)
			   		{
		   			throw new Exception("Invalid Token");
			   		}		   	
			}
		else 
			{
//				throw new InvalidTokenException("Token Not Found");
			return new ResponseEntity<>(true,HttpStatus.OK);
			
			}
		
			//Once we get the token validate it.
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			
			if (jwtUtil.validateToken(jwtToken)) 
				return new ResponseEntity<>("Success",HttpStatus.OK);
			else
				throw new Exception("Invalid Username/Password");
	}
	
	@GetMapping("/check")
	public String check()
	{
		return "Check Success";
	}
	

	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody DAOUser user) throws Exception {
		System.out.println("Hello -------------");
		return ResponseEntity.ok(userDetailsService.save(user));
	}
}
