package com.yasarplusback.YasarPlusBackend.controllers;

import com.yasarplusback.YasarPlusBackend.entities.YasarUser;
import com.yasarplusback.YasarPlusBackend.requests.ImageUploadRequest;
import com.yasarplusback.YasarPlusBackend.requests.TextRequest;
import com.yasarplusback.YasarPlusBackend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/profile") // local:8080/registration
@AllArgsConstructor
public class UserController {
    UserService userService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/{email}")
    public YasarUser getOneUser(@PathVariable(name = "email") String email) {
        YasarUser user = userService.getOneUserMail(email);
        return user;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void uploadImage(@RequestBody ImageUploadRequest imageUploadRequest) {
        YasarUser user = userService.getOneUser(imageUploadRequest.getId());
        user.setImage(imageUploadRequest.getImage());
        userService.saveOneUser(user);
    }
    @PostMapping(path = "/background")
    public void uploadBackground(@RequestBody ImageUploadRequest imageUploadRequest) {
        YasarUser user = userService.getOneUser(imageUploadRequest.getId());
        user.setBackground(imageUploadRequest.getImage());
        userService.saveOneUser(user);
    }
    @PostMapping(path = "/info")
    public void uploadInfo(@RequestBody TextRequest updateInformationRequest) {
        YasarUser user = userService.getOneUser(updateInformationRequest.getId());
        user.setUserInformation(updateInformationRequest.getText());
        userService.saveOneUser(user);
    }
    @PostMapping(path = "/role")
    public void uploadCompanyRole(@RequestBody TextRequest updateInformationRequest) {
        YasarUser user = userService.getOneUser(updateInformationRequest.getId());
        user.setUserInformation(updateInformationRequest.getText());
        userService.saveOneUser(user);
    }
}
