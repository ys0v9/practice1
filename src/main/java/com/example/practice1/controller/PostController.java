package com.example.practice1.controller;

import com.example.practice1.dto.PostRequest;
import com.example.practice1.dto.PostResponse;
import com.example.practice1.security.CustomUserDetails;
import com.example.practice1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostRequest request,
                                    @AuthenticationPrincipal CustomUserDetails userDetails) {
        postService.createPost(request, userDetails.getId());
        return ResponseEntity.ok("Write");
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> all() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody PostRequest request,
                                    @AuthenticationPrincipal CustomUserDetails userDetails) {
        postService.updatePost(id, request, userDetails.getId());
        return ResponseEntity.ok("Update");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id,
                                    @AuthenticationPrincipal CustomUserDetails userDetails) {
        postService.deletePost(id, userDetails.getId());
        return ResponseEntity.ok("Delete");
    }
}