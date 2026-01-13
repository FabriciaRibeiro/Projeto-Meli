package com.meli.socialmeli.controller;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/publish")
    public ResponseEntity<Void> publishPost(@RequestBody Post post) {
        this.postService.savePost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<Post>> getFollowedPosts(@PathVariable Integer userId) {
        List<Post> followedPosts = this.postService.getFollowedPosts(userId);
        return new ResponseEntity<>(followedPosts, HttpStatus.OK);
    }
}