package io.isr.authentication.services;

import io.isr.authentication.dto.RegisterDto;
import io.isr.authentication.entities.Role;
import io.isr.authentication.entities.User;
import io.isr.authentication.repository.RoleRepository;
import io.isr.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	public User findUserByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	public void saveUser(RegisterDto registerDto){
		User user = new User();
		user.setEmail(registerDto.getEmail());
		user.setFirstName(registerDto.getFirstName());
		user.setLastName(registerDto.getLastName());
		user.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));
		user.setEnabled(true);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
		userRepository.save(user);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if(user != null) {
			List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
			return buildUserForAuthentication(user, authorities);
		} else {
			throw new UsernameNotFoundException("username not found");
		}
	}
	
	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<>();
		userRoles.forEach((role) -> {
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		});
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}
	
	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
}
