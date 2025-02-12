package com.example.yoomeesecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 비밀번호 인코더.
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    // 권한 계층 설정.
    @Bean
    public RoleHierarchy roleHierarchy() {

        return RoleHierarchyImpl.withDefaultRolePrefix()
                .role("ADMIN").implies("USER")
                .role("USER").implies("ANONYMOUS")
                .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        .requestMatchers("/", "/login", "/signup","/error/**").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/mypage/**").hasAnyRole( "USER") // 유저 권한 이상 접근 가능.
                        .anyRequest().authenticated()
                );

        http
                .formLogin((auth) -> auth.loginPage("/login") // 파일 이름.
                        .loginProcessingUrl("/login") // api path.
                        .permitAll()
                );

//        http
//                .csrf((auth) -> auth.disable());

        // 다중 로그인 관리.
        http
                .sessionManagement((auth) -> auth
                        .maximumSessions(1) // 다중 로그인 허용 개수.
                        .maxSessionsPreventsLogin(true)); // 초과시 ture: 새유입 차단, false: 기존 세션 삭제.

        // 세션 고정 공격 방어.
        http
                .sessionManagement((auth) -> auth
                        .sessionFixation().changeSessionId()); // 로그인 할 때, 동일한 세션의 id를 변경해서 무용지물로 만듦.

        return http.build();
    }
}
