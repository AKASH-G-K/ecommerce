package com.presidio.E_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.presidio.E_commerce.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
}
