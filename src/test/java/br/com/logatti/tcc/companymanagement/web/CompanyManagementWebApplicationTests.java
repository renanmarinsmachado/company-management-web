package br.com.logatti.tcc.companymanagement.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.companymanagement.web.CompanyManagementWebApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CompanyManagementWebApplication.class)
@WebAppConfiguration
public class CompanyManagementWebApplicationTests {

	@Test
	public void contextLoads() {
	}

}
