package br.com.jtech.springbootapisql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.jtech.springbootapisql.models.Order;
import br.com.jtech.springbootapisql.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Order> findById(@PathVariable("id") Long orderId) {
        Order order = orderService.findById(orderId);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long orderId, @RequestBody Order order) {        
        Order updatedOrder = orderService.updateOrder(orderId, order);
        return ResponseEntity.ok(updatedOrder);
    }
        
    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
