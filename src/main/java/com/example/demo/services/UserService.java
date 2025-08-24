package com.example.demo.services;

import com.example.demo.dto.UserNameAndEmail;
import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User create(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User update(User user) {
        return userRepository.findById(user.getId())
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    return userRepository.save(existingUser);
                })
                .orElse(null);
    }

    public boolean delete(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateUserEmailById(Long id, String email) {
        var user = userRepository.findById(id).orElse(null);
        if(user != null){
            return false;
        }
        if(user.getEmail().equals(email)){
            return false;
        }
        int updated = userRepository.updateUserEmailById(id, email);
        return updated > 0;
    }
    public List<User> findAllWithOrders(){
        return userRepository.findAllWithOrders();
    }
    public Optional<User> findUserWithOrdersById(Long id){
        return userRepository.findUserWithOrdersById(id);
    }
    public Optional<UserNameAndEmail> findUserById(Long id){
        return userRepository.findUserById(id);
    }
}
