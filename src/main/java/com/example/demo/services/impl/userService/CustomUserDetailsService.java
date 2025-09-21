package com.example.demo.services.impl.userService;

import com.example.demo.domain.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.dto.user.CurrentUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new CurrentUserDetails(user.getId(), user.getName(), user.getPassword());
    }
}
