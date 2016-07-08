package br.com.logatti.tcc.companymanagement.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.logatti.tcc.companymanagement.web.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
    public String indexLogin() {
		
//		User user = new User();
//		user.setUsername("admin@admin.com");
//		user.setName("Admin");
//		user.setPassword(new BCryptPasswordEncoder().encode("admin"));
//		user.setRole(Role.ADMIN);
//		userService.save(user);
		
        return "login";
    }
	
	@RequestMapping("/")
    public ModelAndView index() {
		
		ModelAndView modelAndView = new ModelAndView("index");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    modelAndView.addObject("currentUser", userService.getByUsername(username).get());
	    
        return modelAndView;
    }
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
}
