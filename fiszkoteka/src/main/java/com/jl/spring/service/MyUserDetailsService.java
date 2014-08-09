package com.jl.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jl.spring.data.DBUser;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(final String email)
			throws UsernameNotFoundException {
	
		DBUser user = userService.findUserByEmail(email);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoleUser());
		return buildUserForAuthentication(user, authorities);
	}

	private UserDetails buildUserForAuthentication(DBUser user,
			List<GrantedAuthority> authorities) {
		
		
		return new User(user.getEmail(), user.getPass(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(String roleUser) {
		
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>();
		Result.add(new SimpleGrantedAuthority(roleUser));
		
		return Result;
	}

}
