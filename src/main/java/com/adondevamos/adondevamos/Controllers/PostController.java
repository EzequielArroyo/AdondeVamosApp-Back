package com.adondevamos.adondevamos.Controllers;

import com.adondevamos.adondevamos.Entities.Post;
import com.adondevamos.adondevamos.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*")
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping
    public ResponseEntity<List<Post>> getPosts(){
        List<Post> postList = postService.getPosts();
        return ResponseEntity.ok(postList);
    }
}
