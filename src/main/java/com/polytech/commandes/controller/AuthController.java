package com.polytech.commandes.controller;

import com.polytech.commandes.dto.LoginRequest;
import com.polytech.commandes.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        return jwtService.generateToken(request.getUsername());
    }
}