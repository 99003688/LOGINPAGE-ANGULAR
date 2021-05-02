package com.ltts.shadow.smartcafeteria.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.shadow.smartcafeteria.Models.User;
import com.ltts.shadow.smartcafeteria.Models.login;
import com.ltts.shadow.smartcafeteria.Repositories.LoginRepository;
import com.ltts.shadow.smartcafeteria.Repositories.UserRepository;
import com.ltts.shadow.smartcafeteria.Services.UserService;




@CrossOrigin("http://localhost:4200")
@RestController
public class AppController {

	@Autowired
	UserRepository UserRep;
	
	@Autowired
	LoginRepository loginRepo;
	
	@Autowired
	UserService UserSer;
	

	@RequestMapping("/users")
	public List<User> makeList()
	{
		List<User> ls =UserRep.findAll();
		return ls;
	}


	
	@PostMapping("/crusers")
	public User create(@RequestBody User us) {
		
		return UserRep.save(us);
	}
	
//	@PostMapping("/crusers1")
//	public login create(@RequestBody login us) {
//		return loginRepo.save(us);
//		
//	}
	
	
	
	@PostMapping("/login")
	public User LoginUser(@RequestBody User us) throws Exception
	{
		String tempUsername=us.getUsername();
		String tempPassword=us.getPassword();
		User userObj=null;
		
		if(tempUsername!=null && tempPassword!=null)
		{
			userObj=UserSer.FetchUserByUsernameAndPassword(tempUsername, tempPassword);
			login log= new login(us.getUsername(),us.getPassword());
			loginRepo.save(log);
		}
		if(userObj==null)
		{
			throw new Exception("Bad Credentials");
		}
		
		return userObj;
	}
	
}
