package com.meli.socialmeli.service;

import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void followUser(Integer userId, Integer userIdToFollow) {

        User follower = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        User seller = userRepository.findById(userIdToFollow)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado."));

        follower.follow(userIdToFollow);

        seller.getFollowers().add(userId);

        userRepository.save(follower);
        userRepository.save(seller);
    }

    public void unfollowUser(Integer userId, Integer userIdToUnfollow) {
        User follower = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        User seller = userRepository.findById(userIdToUnfollow)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado."));

        follower.unfollow(userIdToUnfollow);
        seller.getFollowers().remove(userId);

        userRepository.save(follower);
        userRepository.save(seller);
    }
}
