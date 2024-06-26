package com.presidio.E_commerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.presidio.E_commerce.model.User;
import com.presidio.E_commerce.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository dao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=dao.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(" The Given Username"+username+" not found");
		}
		return new CustomUserDetails(user);
	}

}
