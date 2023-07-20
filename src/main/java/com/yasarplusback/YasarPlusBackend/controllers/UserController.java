package com.yasarplusback.YasarPlusBackend.controllers;

import com.yasarplusback.YasarPlusBackend.entities.YasarUser;
import com.yasarplusback.YasarPlusBackend.requests.ImageUploadRequest;
import com.yasarplusback.YasarPlusBackend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/profile") //local:8080/registration
@AllArgsConstructor
public class UserController {
    UserService userService;
    @GetMapping(path = "/{id}")
    public YasarUser getUser(@PathVariable(name = "id") Long id){
        YasarUser user = userService.getOneUser(id);
        return user;
    }
    @PostMapping
    public YasarUser uploadImage(@RequestBody ImageUploadRequest imageUploadRequest){
        YasarUser user = userService.getOneUser(imageUploadRequest.getUserId());
        user.setImage(imageUploadRequest.getImage());
        return user;

    }
}
