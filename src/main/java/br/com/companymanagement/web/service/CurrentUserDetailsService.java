package br.com.companymanagement.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.companymanagement.common.client.UserClient;
import br.com.companymanagement.common.dto.UserDTO;
import br.com.companymanagement.web.model.CurrentUser;

@Service
public class CurrentUserDetailsService implements UserDetailsService{

	private final UserClient userClient;
	
	@Autowired
    public CurrentUserDetailsService(UserClient userClient) {
        this.userClient = userClient;
    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 UserDTO userDTO = userClient.getUsers(username).get(0);
		 return new CurrentUser(userDTO);
	}

}
