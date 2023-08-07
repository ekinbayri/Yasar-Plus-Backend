package com.yasarplusback.YasarPlusBackend.controllers;


import com.yasarplusback.YasarPlusBackend.entities.Post;
import com.yasarplusback.YasarPlusBackend.entities.UserLike;
import com.yasarplusback.YasarPlusBackend.requests.AddCommentRequest;
import com.yasarplusback.YasarPlusBackend.requests.AddLikeRequest;
import com.yasarplusback.YasarPlusBackend.requests.AddPostRequest;

import com.yasarplusback.YasarPlusBackend.services.PostService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(path = "/home")
@AllArgsConstructor
public class   PostController {
    @Autowired
    private final PostService postService;


    @PostMapping
    public Post addPost(@RequestBody AddPostRequest postRequest) {
       return postService.savePost(postRequest);
    }
    @GetMapping
    public List<Post> getAllPosts(){return postService.getAllPosts();}

    @PutMapping
    public void addComment(@RequestBody AddCommentRequest addCommentRequest){
        postService.addCommentToPost(addCommentRequest);
    }

    @PutMapping(path="/like")
    public List<UserLike> addLike(@RequestBody AddLikeRequest addLikeRequest){
        return postService.addLikeToPost(addLikeRequest);
    }
}
