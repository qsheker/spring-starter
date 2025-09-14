package com.example.demo.services.impl.userService;

import com.example.demo.domain.entity.User;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findUserByName(username).orElseThrow(
                ()-> new EntityNotFoundException("User with name: "+username+" not found!")
        );

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority())
        );
    }
}
