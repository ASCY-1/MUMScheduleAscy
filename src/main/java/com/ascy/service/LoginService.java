package com.ascy.service;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ascy.domain.Profile;
import com.ascy.repository.ProfileRepository;
import com.ascy.security.UserAuth;
import com.ascy.security.UserToken;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginService {

	
	
	@Autowired
	ProfileRepository profileRepo;
	
	public UserToken authenticate(UserAuth user) throws ServletException {
		
		
		Profile userDb = profileRepo.findByEmail(user.getUserName(), user.getPassword());
		
		if(userDb == null) {
			throw new ServletException("Invalid login");
		}
		
		return new UserToken(Jwts.builder().setSubject(user.getUserName())
				.claim("role",userDb.getRole())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS512,UserToken.secretKey)
				.compact());
		
		}
	
}
