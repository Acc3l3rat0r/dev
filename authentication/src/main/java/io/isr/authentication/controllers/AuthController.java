package com.example.reglogv2.controllers;

import com.example.reglogv2.configs.JwtTokenProvider;
import com.example.reglogv2.model.User;
import com.example.reglogv2.repositories.UserRepository;
import com.example.reglogv2.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private CustomUserDetailsService userService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AuthBody data) {
		try {
			String username = data.getEmail();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
			String token = jwtTokenProvider.createToken(username, this.userRepository.findByEmail(username).getRoles());
			Map<Object, Object> model = new HashMap<>();
			model.put("email", username);
			model.put("token", token);
			return ok(model);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid email/password supplied");
		}
	}
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody User user) {
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			throw new BadCredentialsException("User with email: " + user.getEmail() + " already exists");
		}
		userService.saveUser(user);
		Map<Object, Object> model = new HashMap<>();
		model.put("message", "User registered successfully");
		return ok(model);
	}
}
