package com.yasarplusback.YasarPlusBackend.services;

import com.yasarplusback.YasarPlusBackend.requests.RegistrationRequest;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {
    public String register(RegistrationRequest request) {

        return "it is working.";
    }
}
