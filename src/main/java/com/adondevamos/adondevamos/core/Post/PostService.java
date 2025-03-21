package com.adondevamos.adondevamos.core.Post;

import com.adondevamos.adondevamos.Dto.PostCreateDTO;
import com.adondevamos.adondevamos.core.User.User;
import com.adondevamos.adondevamos.Exception.EntityNotFoundException;
import com.adondevamos.adondevamos.core.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPotsByTitle(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("post with id: " + id + "not found"));
    }

    public Post createPost(PostCreateDTO postRequest) {
        User postOwner = userRepository.findByUsername(postRequest.getOwnerUsername())
                .orElseThrow(() -> new EntityNotFoundException(postRequest.getOwnerUsername() + " not found"));
        Post newPost = Post.builder()
                .title(postRequest.getTitle())
                .datetime(postRequest.getDatetime())
                .description(postRequest.getDescription())
                .location(postRequest.getLocation())
                .owner(postOwner)
                .cantParticipants(0)
                .maxParticipants(postRequest.getMaxParticipants())
                .category(postRequest.getCategory())
                .build();
        return postRepository.save(newPost);
    }

    public Post updatePost(Long id, Post updatePost) {
        postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("post with id: " + id + "not found"));
        postRepository.save(updatePost);
        return updatePost;
    }

    public Post deletePostById(long id)  {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("post with id: " + id + "not found"));
        postRepository.deleteById(id);
        return post;
    }
}
