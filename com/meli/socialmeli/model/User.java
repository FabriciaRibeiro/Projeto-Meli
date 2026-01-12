package com.meli.socialmeli.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId; // O Banco de dados gera este ID automaticamente.

    private String userName; // Nome do usuário, limitado a 15 caracteres.

    @ElementCollection
    private List<Integer> followed = new ArrayList<>();

    @ElementCollection
    private List<Integer> followers = new ArrayList<>();

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Integer> getFollowed() {
        return followed;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void follow(Integer sellerId) {
        if (!this.followed.contains(sellerId)) {
            this.followed.add(sellerId);
        }
    }

    public void unfollow(Integer sellerId) {
        this.followed.remove(sellerId);
    }
}