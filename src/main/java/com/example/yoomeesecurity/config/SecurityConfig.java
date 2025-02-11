package com.example.yoomeesecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        .requestMatchers("/", "/login").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/mypage/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                );

        http
                .formLogin((auth) -> auth.loginPage("/login")
                        .loginProcessingUrl("/loginProcessing")
                        .permitAll()
                );

        // 초기 실습 편의를 위해 csrf 토큰 설정 잠시 비활성화.
        http
                .csrf((auth) -> auth.disable());

        return http.build();
    }
}
