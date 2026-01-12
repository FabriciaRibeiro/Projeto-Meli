package com.meli.socialmeli.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;

    private Integer userId;
    private LocalDate date;

    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private Integer category;
    private Double price;

    @ElementCollection
    private List<String> testimonials = new ArrayList<>(); // Lista de comentários/depoimentos.

    public Post() {
    }

    public Integer getIdPost() { return idPost; }
    public void setIdPost(Integer idPost) { this.idPost = idPost; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public List<String> getTestimonials() { return testimonials; }

    public void addTestimonial(String text) {
        if (text != null && !text.isBlank()) {
            this.testimonials.add(text);
        }
    }
}