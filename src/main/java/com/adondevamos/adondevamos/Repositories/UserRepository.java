package com.adondevamos.adondevamos.Repositories;

import com.adondevamos.adondevamos.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
