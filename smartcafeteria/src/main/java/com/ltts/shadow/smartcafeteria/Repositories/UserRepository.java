package com.ltts.shadow.smartcafeteria.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ltts.shadow.smartcafeteria.Models.User;

public interface UserRepository extends JpaRepository<User, String> 
{
	@Query("SELECT k FROM User k WHERE k.username = ?1")
	public User findByUsername(String username);

	public User findByUsernameAndPassword(String tempUsername,String password);
	
	

}
