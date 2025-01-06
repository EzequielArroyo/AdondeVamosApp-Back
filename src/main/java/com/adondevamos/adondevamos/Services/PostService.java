package com.adondevamos.adondevamos.Services;

import com.adondevamos.adondevamos.Dtos.Post.CreatePostDTO;
import com.adondevamos.adondevamos.Dtos.Post.UpdatePostDTO;
import com.adondevamos.adondevamos.Entities.Post;
import com.adondevamos.adondevamos.Entities.User;
import com.adondevamos.adondevamos.Repositories.PostRepository;
import com.adondevamos.adondevamos.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    //CREATE POST
    public Post createPost(CreatePostDTO request){
        User user = userRepository.findById(request.getCreatedBy())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setCreateBy(user);
        return postRepository.save(post);
    }

    //GET ALL POSTS
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    //GET POST
    public Post getPostById(Long postId){
        return postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    //PUT POST
    public Post updatePost(Long postId, UpdatePostDTO updatePost) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));


        if (updatePost.getTitle() != null) {
            post.setTitle(updatePost.getTitle());
        }
        if (updatePost.getParticipantsId() != null) {
            List<Long> participantsId = updatePost.getParticipantsId();
            List<User> participantsUser = participantsId.stream()
                    .map(id -> userRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found")))
                    .toList();
            post.getJoinedUsers().addAll(participantsUser);
        }
        return postRepository.save(post);
    }
    //DELETE POST
    public void deletePostById(Long postId){
        if(postRepository.existsById(postId)){
            postRepository.deleteById(postId);
        }else{
            throw new RuntimeException("Post with ID " + postId + " not found");
        }
    }
}
