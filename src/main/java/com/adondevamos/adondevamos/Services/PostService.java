package com.adondevamos.adondevamos.Services;

import com.adondevamos.adondevamos.Entities.Post;
import com.adondevamos.adondevamos.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getPosts(){
        return postRepository.findAll();
    }
}
