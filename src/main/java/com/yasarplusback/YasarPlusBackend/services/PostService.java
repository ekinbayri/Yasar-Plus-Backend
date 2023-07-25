package com.yasarplusback.YasarPlusBackend.services;

import com.yasarplusback.YasarPlusBackend.entities.Post;
import com.yasarplusback.YasarPlusBackend.entities.YasarUser;
import com.yasarplusback.YasarPlusBackend.repositories.PostRepository;
import com.yasarplusback.YasarPlusBackend.repositories.UserRepository;
import com.yasarplusback.YasarPlusBackend.requests.AddPostRequest;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    UserRepository userRepository;
    PostRepository postRepository;
    public void savePost(AddPostRequest postRequest){
        String image = postRequest.getImage();
        long id = postRequest.getUserId();
        String text = postRequest.getText();
        YasarUser user = userRepository.findById(id).orElse(null);
        if(image != null){
            Post post = new Post(user,text,image);
            postRepository.save(post);
        }
        else{
            Post post = new Post(user,text);
            postRepository.save(post);
        }

    }
}
