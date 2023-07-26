package com.yasarplusback.YasarPlusBackend.controllers;


import com.yasarplusback.YasarPlusBackend.entities.Post;
import com.yasarplusback.YasarPlusBackend.requests.AddCommentRequest;
import com.yasarplusback.YasarPlusBackend.requests.AddPostRequest;
import com.yasarplusback.YasarPlusBackend.requests.TextRequest;
import com.yasarplusback.YasarPlusBackend.services.PostService;
import com.yasarplusback.YasarPlusBackend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/home")
@AllArgsConstructor
public class PostController {
    @Autowired
    private final PostService postService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public void addPost(@RequestBody AddPostRequest postRequest) {
        postService.savePost(postRequest);
    }
    @GetMapping
    public List<Post> getAllPosts(){return postService.getAllPosts();}
    @PutMapping
    public void addComment(@RequestBody AddCommentRequest addCommentRequest){
        postService.addCommentToPost(addCommentRequest);
    }
}
