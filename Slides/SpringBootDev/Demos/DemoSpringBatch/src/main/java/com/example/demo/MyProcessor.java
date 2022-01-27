package com.example.demo;

import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyProcessor implements ItemProcessor<User, User>{

	@Autowired
	private UsersRepository userRepo;

	@Override
	public User process(User user) throws Exception {
		Optional<User> userFromDb = userRepo.findById(user.getUserId());
		if(userFromDb.isPresent()) {
			User dbUser = userFromDb.get();
			if(dbUser.getDept().equalsIgnoreCase("it")) {
				user.setSalary(dbUser.getSalary()+ 5050);
			} else {
				user.setSalary(dbUser.getSalary()+ 5000);
			}
		}
		return user;
	}
}
