package br.com.companymanagement.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.companymanagement.web.client.UserClient;

@Controller
public class LoginController {
	
	@Autowired
	private UserClient userClient;
	
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
	    modelAndView.addObject("currentUser", userClient.getUserByUsername(username));
	    
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
	
//	public static void main(String[] args) {
//		System.out.println(new BCryptPasswordEncoder().encode("admin"));
//	}
}
