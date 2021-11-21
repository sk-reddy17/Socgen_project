package com.shashi.APIGateway.service;

import com.shashi.APIGateway.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;



public interface UserService extends UserDetailsService
{
	public UserDetails loadUserByUsername(String username);
	public UserDto signup(UserDto userDto);
	public UserDto activate(String token);
	public UserDto update(UserDto userDto);
}
