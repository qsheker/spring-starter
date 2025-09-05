package com.example.demo.services.impl;

import com.example.demo.domain.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        if(!userRepository.existsById(user.getId())){
            throw new EntityNotFoundException("User not found with id: "+user.getId());
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean updateUserEmailById(Long id, String email) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found with id: " + id));
        if(user.getEmail().equalsIgnoreCase(email)){
            throw new EntityNotFoundException("Can not change the email!");
        }
        int updated = userRepository.updateUserEmailById(id,email);
        return updated>0;

    }

    @Override
    public List<User> findAllWithOrders() {
        return userRepository.findAllWithOrders();
    }

    @Override
    public User findUserWithOrdersById(Long id) {
        return userRepository.findUserWithOrdersById(id)
                .orElseThrow(()->new EntityNotFoundException("User not found with id: " + id));
    }
}
