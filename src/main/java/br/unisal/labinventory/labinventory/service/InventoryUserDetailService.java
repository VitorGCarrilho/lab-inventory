package br.unisal.labinventory.labinventory.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.unisal.labinventory.labinventory.model.User;
import br.unisal.labinventory.labinventory.repository.UserRepository;

@Service
public class InventoryUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if (user == null){
			throw new UsernameNotFoundException(username);
		}
		Set<SimpleGrantedAuthority> authorities = new HashSet<>(); 
		authorities.add(new SimpleGrantedAuthority(user.getUserType().toString()));
		System.out.println(user.getUserType().toString());
		return new org.springframework.security.core.userdetails.User(username, user.getCpf(), authorities);
	}

}
