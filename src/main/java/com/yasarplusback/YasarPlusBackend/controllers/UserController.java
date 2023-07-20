package com.yasarplusback.YasarPlusBackend.controllers;

import com.yasarplusback.YasarPlusBackend.entities.YasarUser;
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
    public YasarUser uploadImage( byte[] image, Long userId){
        YasarUser user = userService.getOneUser(userId);
        user.setImage(image);
        return user;

    }
}
