package com.cyberaka.quiz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyberaka.quiz.dao.UserRepository;
import com.cyberaka.quiz.domain.User;
import com.cyberaka.quiz.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User login(String userName, String password) {
		return userRepo.login(userName, password);
	}

	@Override
	public User find(int id) {
		return userRepo.findOne(id);
	}
}
