package com.adondevamos.adondevamos.Controllers;

import com.adondevamos.adondevamos.Dto.PostCreateDTO;
import com.adondevamos.adondevamos.Entities.Post;
import com.adondevamos.adondevamos.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/post")
@CrossOrigin(origins = "*")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getPosts(){
        List<Post> postList = postService.getPosts();
        return ResponseEntity.ok(postList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> getPostByTitle(@PathVariable Long id){
        Post post = postService.getPotsByTitle(id);
        return  ResponseEntity.ok(post);
    }
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostCreateDTO newPost){
        Post createdpost = postService.createPost(newPost);
        return ResponseEntity.ok(createdpost);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post updatePost){
        Post updatedPost = postService.updatePost(id,updatePost);
        return ResponseEntity.ok(updatedPost);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable long id){
        Post deletedPost = postService.deletePostById(id);
        return ResponseEntity.ok(deletedPost);
    }

}
