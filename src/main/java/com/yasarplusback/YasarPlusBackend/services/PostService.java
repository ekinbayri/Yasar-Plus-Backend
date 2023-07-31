package com.yasarplusback.YasarPlusBackend.services;

import com.yasarplusback.YasarPlusBackend.entities.Post;
import com.yasarplusback.YasarPlusBackend.entities.UserComment;
import com.yasarplusback.YasarPlusBackend.entities.UserLike;
import com.yasarplusback.YasarPlusBackend.entities.YasarUser;
import com.yasarplusback.YasarPlusBackend.repositories.CommentRepository;
import com.yasarplusback.YasarPlusBackend.repositories.LikeRepository;
import com.yasarplusback.YasarPlusBackend.repositories.PostRepository;
import com.yasarplusback.YasarPlusBackend.repositories.UserRepository;
import com.yasarplusback.YasarPlusBackend.requests.AddCommentRequest;
import com.yasarplusback.YasarPlusBackend.requests.AddLikeRequest;
import com.yasarplusback.YasarPlusBackend.requests.AddPostRequest;
import com.yasarplusback.YasarPlusBackend.requests.TextRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    LikeRepository likeRepository;

    public Post savePost(AddPostRequest postRequest){
        String image = postRequest.getImage();
        long id = postRequest.getId();
        String text = postRequest.getText();
        YasarUser user = userRepository.findById(id).orElse(null);
        if(image != null){
            Post post = new Post(user,text,image);
            postRepository.save(post);
            return post;
        }
        else{
            Post post = new Post(user,text);
            postRepository.save(post);
            return post;
        }

    }
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
    public void addCommentToPost(AddCommentRequest addCommentRequest){
        String text = addCommentRequest.getText();
        YasarUser user = userRepository.findById(addCommentRequest.getUserId()).orElse(null);
        long postId = addCommentRequest.getPostId();
        Optional<Post> post = postRepository.findById(postId);
        UserComment userComment = new UserComment(user,text);
        commentRepository.save(userComment);

        if(post.isPresent()){
            Post userPost = post.get();
            List<UserComment> comments = userPost.getUserComment();
            comments.add(userComment);
            userPost.setUserComment(comments);
            postRepository.save(userPost);
        }
    }
    public List<UserLike> addLikeToPost(AddLikeRequest addLikeRequest){
        YasarUser user = userRepository.findById(addLikeRequest.getUserId()).orElse(null);
        long postId = addLikeRequest.getPostId();
        Optional<Post> post = postRepository.findById(postId);
        UserLike userLike = new UserLike(user);
        likeRepository.save(userLike);
        Post userPost = post.get();
        List<UserLike> likes = userPost.getUserLike();
        likes.add(userLike);
        userPost.setUserLike(likes);


        postRepository.save(userPost);

        return likes;
    }
}
