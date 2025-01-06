package com.adondevamos.adondevamos.Controllers;


import com.adondevamos.adondevamos.Dtos.Post.CreatePostDTO;
import com.adondevamos.adondevamos.Dtos.Post.UpdatePostDTO;
import com.adondevamos.adondevamos.Entities.Post;
import com.adondevamos.adondevamos.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody CreatePostDTO request){
        Post createdPost = postService.createPost(request);
        return ResponseEntity.ok(createdPost);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody UpdatePostDTO updatePost){
        Post updatedPost = postService.updatePost(id, updatePost);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }
}
