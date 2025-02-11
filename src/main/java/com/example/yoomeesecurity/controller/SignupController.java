package com.example.yoomeesecurity.controller;

import com.example.yoomeesecurity.dto.SignupDto;
import com.example.yoomeesecurity.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignupController {

    private final SignupService signupService;

    @GetMapping("/signup")
    public String signupPage() {

        return "signup";
    }

    @PostMapping("/signup")
    public String signupProcess(SignupDto signupDto) {

        signupService.signupProcess(signupDto);

        return "redirect:/login";
    }
}
