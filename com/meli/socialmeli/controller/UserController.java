package com.meli.socialmeli.controller;

import com.meli.socialmeli.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}