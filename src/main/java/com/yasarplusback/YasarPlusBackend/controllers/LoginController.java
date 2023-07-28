package com.yasarplusback.YasarPlusBackend.controllers;

import com.yasarplusback.YasarPlusBackend.requests.LoginRequest;
import com.yasarplusback.YasarPlusBackend.responses.LoginResponse;
import com.yasarplusback.YasarPlusBackend.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(path = "/login") // local:8080/registration
@AllArgsConstructor
public class LoginController {

    @Autowired
    private final LoginService loginService;


    @PostMapping
    public ResponseEntity<?> loginEmployee(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = loginService.loginUser(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }

}
