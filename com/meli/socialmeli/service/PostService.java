package com.meli.socialmeli.service;

import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;


@Service
public class PostService {

    private final PostRepository postRepository;
    private final RestTemplate restTemplate;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
        this.restTemplate = new RestTemplate();
    }

    public Post createPost(Integer sellerId, String mlProductId) {
        String url = "https://api.mercadolibre.com/items/" + mlProductId;

        try {

            Map<String, Object> productData = restTemplate.getForObject(url, Map.class);

            Post post = new Post();
            post.setUserId(sellerId);

            post.setProductName((String) productData.get("title"));
            post.setPrice(Double.valueOf(productData.get("price").toString()));

            return postRepository.save(post);

        } catch (Exception e) {

            throw new RuntimeException("Mercadoria inexistente no Mercado Livre! Postagem cancelada.");
        }
    }
}