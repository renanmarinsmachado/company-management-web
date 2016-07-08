package br.com.logatti.tcc.companymanagement.web.model;

import org.springframework.security.core.authority.AuthorityUtils;

import br.com.logatti.tcc.companymanagement.web.entity.User;
import br.com.logatti.tcc.companymanagement.web.enums.Role;

public class CurrentUser extends org.springframework.security.core.userdetails.User{

	/**
	 * 
	 */
	private static final long serialVersionUID = -288817689858787941L;
	
	private User user;

    public CurrentUser(User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

}
