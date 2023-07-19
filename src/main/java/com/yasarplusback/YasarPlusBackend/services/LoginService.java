package com.yasarplusback.YasarPlusBackend.services;

import com.yasarplusback.YasarPlusBackend.entities.YasarUser;
import com.yasarplusback.YasarPlusBackend.repositories.LoginRepository;
import com.yasarplusback.YasarPlusBackend.repositories.UserRepository;
import com.yasarplusback.YasarPlusBackend.requests.LoginRequest;
import com.yasarplusback.YasarPlusBackend.responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public LoginResponse loginUser(LoginRequest loginRequest) {
        String msg = "";
        YasarUser user = loginRepo.findByEmail(loginRequest.getEmail());
        if (user != null) {
            String password = loginRequest.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = bCryptPasswordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<YasarUser> yasarUser = loginRepo.findOneByEmailAndPassword(loginRequest.getEmail(), encodedPassword);
                if (yasarUser.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("credentials does not match", false);
            }
        }else {
            return new LoginResponse("credentials does not match", false);
        }
    }
}

