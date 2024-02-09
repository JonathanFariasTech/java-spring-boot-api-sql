package br.com.jtech.springbootapisql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jtech.springbootapisql.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByName(String name);
}
