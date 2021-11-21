package com.shashi.APIGateway.initializer;

import com.shashi.APIGateway.dao.UserRepository;
import com.shashi.APIGateway.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



@Component
public class UserServiceApplicationInitializer implements CommandLineRunner
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception 
	{
		userRepository.deleteAll();
		User admin = new User("admin", passwordEncoder.encode("admin"), "sai@gmail.com", "9959070877");
		admin.setRole("ADMIN");
		admin.setConfirmed(true);
		userRepository.save(admin);
	}
}
