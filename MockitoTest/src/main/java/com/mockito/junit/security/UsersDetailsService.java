package com.mockito.junit.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mockito.junit.exception.UsernameNotFound;
import com.mockito.junit.model.Customer;
import com.mockito.junit.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersDetailsService implements UserDetailsService {
	private final CustomerRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer user = Optional.of(userRepository.findByUsername(username)).orElseThrow(()->new UsernameNotFound("Username is not found"));
		return new UsersDetails(user);
	}

}
