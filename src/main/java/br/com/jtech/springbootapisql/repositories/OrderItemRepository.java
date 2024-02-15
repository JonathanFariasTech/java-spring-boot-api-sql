package br.com.jtech.springbootapisql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jtech.springbootapisql.models.OrderItem;
import br.com.jtech.springbootapisql.models.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
