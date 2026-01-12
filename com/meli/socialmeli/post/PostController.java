package com.meli.socialmeli.controller;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.service.PostService;
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
        postService.savePost(post);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<List<Post>> getFollowedList(@PathVariable Integer userId) {
        List<Post> posts = postService.getFollowedPosts(userId);
        return ResponseEntity.ok(posts);
    }
}