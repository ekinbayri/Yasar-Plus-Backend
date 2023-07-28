package com.yasarplusback.YasarPlusBackend.controllers;

import com.yasarplusback.YasarPlusBackend.requests.RegistrationRequest;
import com.yasarplusback.YasarPlusBackend.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path ="/registration") //local:8080/registration
@AllArgsConstructor



public class RegistrationController {


    private final RegistrationService registrationService;



    @PostMapping
    public String register(@RequestBody RegistrationRequest request){

            return registrationService.register(request);

    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }


}
