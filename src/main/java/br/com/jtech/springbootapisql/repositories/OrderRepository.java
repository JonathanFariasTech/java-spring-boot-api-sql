package br.com.jtech.springbootapisql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jtech.springbootapisql.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
