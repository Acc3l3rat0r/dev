package io.isr.authentication.controllers;

import io.isr.authentication.configs.JwtTokenProvider;
import io.isr.authentication.dto.LoginDto;
import io.isr.authentication.dto.RegisterDto;
import io.isr.authentication.dto.UserOut;
import io.isr.authentication.entities.User;
import io.isr.authentication.repository.UserRepository;
import io.isr.authentication.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
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
	public ResponseEntity login(@RequestBody LoginDto loginDto) {
		try {
			String username = loginDto.getEmail();
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginDto.getPassword()));
			String token = jwtTokenProvider.createToken(username, this.userRepository.findByEmail(username).getRoles());
			Map<Object, Object> model = new HashMap<>();
			model.put("token", token);
			return ok(model);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid email/password supplied");
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody RegisterDto registerDto) {
		User userExists = userService.findUserByEmail(registerDto.getEmail());
		if (userExists != null) {
			throw new BadCredentialsException("User with email: " + registerDto.getEmail() + " already exists");
		}
		userService.saveUser(registerDto);
		Map<Object, Object> model = new HashMap<>();
		model.put("message", "User registered successfully");
		return ok(model);
	}
	
	@GetMapping("/getUser/{token}")
	public UserOut getUser(@PathVariable String token){
		String email = jwtTokenProvider.getUsername(token);
		UserOut userOut = new UserOut();
		User user = userRepository.findByEmail(email);
		userOut.setEmail(user.getEmail());
		userOut.setFirstName(user.getFirstName());
		userOut.setLastName(user.getLastName());
		return userOut;
	}
}
