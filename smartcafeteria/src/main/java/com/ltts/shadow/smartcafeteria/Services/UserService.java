package com.ltts.shadow.smartcafeteria.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.shadow.smartcafeteria.Models.User;
import com.ltts.shadow.smartcafeteria.Repositories.UserRepository;

@Service
public class UserService
{
	@Autowired
	private UserRepository UserRep;
	
	public User FetchUserByUsernameAndPassword(String tempUsername, String password)
	{
		return UserRep.findByUsernameAndPassword(tempUsername, password);
	}
}