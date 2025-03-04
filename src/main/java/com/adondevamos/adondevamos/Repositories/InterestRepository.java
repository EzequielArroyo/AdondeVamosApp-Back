package com.adondevamos.adondevamos.Repositories;

import com.adondevamos.adondevamos.Entities.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
}
