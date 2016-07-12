package br.com.companymanagement.web.client;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.companymanagement.common.dto.UserDTO;

@Service
public class UserClient {

	@SuppressWarnings("unchecked")
	public List<UserDTO> getUsers(){
		RestTemplate restTemplate = new RestTemplate();
		return (List<UserDTO>) restTemplate.getForObject("http://localhost:8082/ed/user", UserDTO.class);
	}
	
	public UserDTO getUserByUsername(String username){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject("http://localhost:8082/ed/user/filter", new UserDTO("", username, ""), UserDTO.class);
	}
}
