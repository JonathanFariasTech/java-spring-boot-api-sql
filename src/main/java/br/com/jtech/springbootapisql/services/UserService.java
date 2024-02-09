package br.com.jtech.springbootapisql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jtech.springbootapisql.models.User;
import br.com.jtech.springbootapisql.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user){
        User obj = userRepository.getReferenceById(id);
        obj.setName(user.getName());
        obj.setEmail(user.getEmail());
        obj.setPhone(user.getPhone());
        obj.setPassword(user.getPassword());
        return userRepository.save(obj);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
