package br.com.companymanagement.web.model;

import org.springframework.security.core.authority.AuthorityUtils;

import br.com.companymanagement.common.dto.UserDTO;
import br.com.companymanagement.common.enums.Role;

public class CurrentUser extends org.springframework.security.core.userdetails.User{

	/**
	 * 
	 */
	private static final long serialVersionUID = -288817689858787941L;
	
	private UserDTO user;

    public CurrentUser(UserDTO user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

}
