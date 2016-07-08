package br.com.logatti.tcc.companymanagement.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.logatti.tcc.companymanagement.web.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findOneByUsername(String username);
}
