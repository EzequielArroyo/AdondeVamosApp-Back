package com.adondevamos.adondevamos.Controllers;


import com.adondevamos.adondevamos.Entities.Post;
import com.adondevamos.adondevamos.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post getProductById(@PathVariable Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }
    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post postDetail){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setTitle(postDetail.getTitle());
        post.setHostId(postDetail.getHostId());

        return postRepository.save(post);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
        return "The post"+ id + "was deleted correctly";
    }
}
