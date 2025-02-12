package com.example.yoomeesecurity.service;

import com.example.yoomeesecurity.domains.user.User;
import com.example.yoomeesecurity.domains.user.UserRepository;
import com.example.yoomeesecurity.dto.UserDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user != null) {
            return new UserDetailsDto(user);
        }

        return null;
    }
}
