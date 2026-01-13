package com.meli.socialmeli.controller;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.service.PostService;
import com.meli.socialmeli.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        userService.followUser(userId, userIdToFollow);
        return ResponseEntity.ok().build(); // Retorna Status 200 OK [cite: 44]
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollowUser(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        userService.unfollowUser(userId, userIdToUnfollow);
        return ResponseEntity.ok().build();
    }

    @RestController
    @RequestMapping("/products")
    public static class PostController {

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
}