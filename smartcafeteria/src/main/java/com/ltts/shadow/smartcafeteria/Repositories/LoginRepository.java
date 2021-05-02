package com.ltts.shadow.smartcafeteria.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ltts.shadow.smartcafeteria.Models.login;

public interface LoginRepository extends JpaRepository<login, String> {
	
	@Query("SELECT u FROM login u WHERE u.username = ?1")
	public login findByUsername(String username);

 
}

