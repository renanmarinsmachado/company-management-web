package br.com.logatti.tcc.companymanagement.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.logatti.tcc.companymanagement.web.entity.User;
import br.com.logatti.tcc.companymanagement.web.model.CurrentUser;

@Service
public class CurrentUserDetailsService implements UserDetailsService{

	private final UserService userService;
	
	@Autowired
    public CurrentUserDetailsService(UserService userService) {
        this.userService = userService;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userService.getByUsername(username)
	                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", username)));
	        return new CurrentUser(user);
	}

}
