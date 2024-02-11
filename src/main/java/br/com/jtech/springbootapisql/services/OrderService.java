package br.com.jtech.springbootapisql.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jtech.springbootapisql.models.Order;
import br.com.jtech.springbootapisql.repositories.OrderRepository;

@SuppressWarnings("null")
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order){
        Order obj = orderRepository.getReferenceById(id);
        obj.setMoment(Instant.now());
        obj.setOrderStatus(order.getOrderStatus());
        return orderRepository.save(obj);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
