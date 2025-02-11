package com.example.yoomeesecurity.service;

import com.example.yoomeesecurity.domains.user.User;
import com.example.yoomeesecurity.domains.user.UserRepository;
import com.example.yoomeesecurity.dto.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.yoomeesecurity.domains.user.AccountRole.USER;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signupProcess(SignupDto signupDto) {

        // username 중복 검사 필요.

        User newUser =
                User.builder()
                        .username(signupDto.getUsername())
                        .password(passwordEncoder.encode(signupDto.getPassword()))
                        .role(USER)
                        .build();

        userRepository.save(newUser);
    }
}
