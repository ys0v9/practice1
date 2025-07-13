package com.example.practice1.dto;

import com.example.practice1.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }

    public static PostResponse fromEntity(Post post) {
        return new PostResponse(post);
    }
}
