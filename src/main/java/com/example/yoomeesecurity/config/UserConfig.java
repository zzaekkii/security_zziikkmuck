package com.example.yoomeesecurity.config;

import com.example.yoomeesecurity.domains.user.AccountRole;
import com.example.yoomeesecurity.domains.user.User;
import com.example.yoomeesecurity.domains.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("testUser") == null) {
                userRepository.save(new User("testUser", passwordEncoder.encode("test1234!"), AccountRole.USER));
            }
        };
    }

}
