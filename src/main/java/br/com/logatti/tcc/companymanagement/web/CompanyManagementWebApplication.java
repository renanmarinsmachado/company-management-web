package br.com.logatti.tcc.companymanagement.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class CompanyManagementWebApplication{

	public static void main(String[] args) {
		SpringApplication.run(CompanyManagementWebApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
	    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	    characterEncodingFilter.setEncoding("UTF-8");
	    registrationBean.setFilter(characterEncodingFilter);
	    return registrationBean;
	}
}
