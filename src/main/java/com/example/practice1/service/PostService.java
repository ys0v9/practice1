package com.example.practice1.service;
import com.example.practice1.domain.Post;
import com.example.practice1.domain.User;
import com.example.practice1.dto.PostRequest;
import com.example.practice1.dto.PostResponse;
import com.example.practice1.repository.PostRepository;
import com.example.practice1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void createPost(PostRequest request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("X"));

        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(user)
                .build();

        postRepository.save(post);
    }

    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("X"));
        return new PostResponse(post);
    }

    public void updatePost(Long id, PostRequest request, Long userId) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("X"));

        if (!post.getAuthor().getId().equals(userId)) {
            throw new RuntimeException("X");
        }

        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        postRepository.save(post);
    }

    public void deletePost(Long id, Long userId) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("X"));

        if (!post.getAuthor().getId().equals(userId)) {
            throw new RuntimeException("X");
        }

        postRepository.delete(post);
    }
}
