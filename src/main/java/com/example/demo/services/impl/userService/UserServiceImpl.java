package com.example.demo.services.impl.userService;

import com.example.demo.domain.entity.User;
import com.example.demo.enums.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    @Transactional
    @PreAuthorize("permitAll()")
    public User save(User user) {
        String encoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(encoded);
        user.setRole(Role.CUSTOMER);
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
    @PreAuthorize("#id = authentication.principal.id or hasRole('ADMIN')")
    public void deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }

    @Override
    @PreAuthorize("#id = authentication.principal.id or hasRole('ADMIN')")
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found with id: " + id));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    @PreAuthorize("#userIdEmailDto.id = authentication.principal.id or hasRole('ADMIN')")
    public User updateUserEmailById(Long id, String email) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found with id: " + id));
        if(user.getEmail().equalsIgnoreCase(email)){
            throw new IllegalArgumentException("Can not change the email!");
        }
        user.setEmail(email);
        return user;

    }

    @Override
    @PreAuthorize("#id = authentication.principal.id or hasRole('ADMIN')")
    public BigDecimal getTotalPriceOfUserProductById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("User not found with id: " + id));
        return userRepository.getTotalPriceByUserId(id);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> findAllWithOrders() {
        return userRepository.findAllWithOrders();
    }

    @Override
    @PreAuthorize("#id = authentication.principal.id or hasRole('ADMIN')")
    public User findUserWithOrdersById(Long id) {
        return userRepository.findUserWithOrdersById(id)
                .orElseThrow(()->new EntityNotFoundException("User not found with id: " + id));
    }
}
