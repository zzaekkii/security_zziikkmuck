package com.example.yoomeesecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 로그인한 사용자에게 띄워줄 정보 추가.
        if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getName())) {
            String userId = authentication.getName();
            String role = authentication.getAuthorities().iterator().next().getAuthority(); // 하나만 존재함

            model.addAttribute("userId", userId);
            model.addAttribute("role", role);
            model.addAttribute("randomSeed", UUID.randomUUID().toString().substring(0, 8));
        }

        return "main";
    }
}
