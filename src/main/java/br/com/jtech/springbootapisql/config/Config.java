package br.com.jtech.springbootapisql.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.jtech.springbootapisql.models.Order;
import br.com.jtech.springbootapisql.models.User;
import br.com.jtech.springbootapisql.repositories.OrderRepository;
import br.com.jtech.springbootapisql.repositories.UserRepository;

@Configuration
public class Config implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @SuppressWarnings("null")
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), null, u1);
        Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), null, u2);
        Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), null, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
