package com.yasarplusback.YasarPlusBackend.services;

import com.yasarplusback.YasarPlusBackend.requests.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service
@AllArgsConstructor
public class EmailValidatorService implements Predicate<String> {


    @Override
    public boolean test(String s) {

        //TODO regex e-mail validation
        return true;
    }
}
