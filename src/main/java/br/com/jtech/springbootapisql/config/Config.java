package br.com.jtech.springbootapisql.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.jtech.springbootapisql.models.Category;
import br.com.jtech.springbootapisql.models.Order;
import br.com.jtech.springbootapisql.models.OrderItem;
import br.com.jtech.springbootapisql.models.Product;
import br.com.jtech.springbootapisql.models.User;
import br.com.jtech.springbootapisql.repositories.CategoryRepository;
import br.com.jtech.springbootapisql.repositories.OrderItemRepository;
import br.com.jtech.springbootapisql.repositories.OrderRepository;
import br.com.jtech.springbootapisql.repositories.ProductRepository;
import br.com.jtech.springbootapisql.repositories.UserRepository;

@Configuration
public class Config implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(Instant.parse("2019-06-20T19:53:07Z"), 1, u1);
        Order o2 = new Order(Instant.parse("2019-07-21T03:42:10Z"), 1, u2);
        Order o3 = new Order(Instant.parse("2019-07-22T15:21:22Z"), 1, u1);
        
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
    }
}
