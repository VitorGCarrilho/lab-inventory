package br.unisal.labinventory.labinventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisal.labinventory.labinventory.model.User;
import br.unisal.labinventory.labinventory.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void save(User user){
		userRepository.save(user);
	}
}
