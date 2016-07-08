package br.com.logatti.tcc.companymanagement.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.logatti.tcc.companymanagement.web.entity.User;
import br.com.logatti.tcc.companymanagement.web.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public Optional<User> getByUsername(String username){
		return repository.findOneByUsername(username);
	}
	
	public void save(User user){
		repository.save(user);
	}
}
