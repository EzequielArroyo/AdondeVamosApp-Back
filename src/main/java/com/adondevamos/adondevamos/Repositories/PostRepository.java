package com.adondevamos.adondevamos.Repositories;

import com.adondevamos.adondevamos.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
