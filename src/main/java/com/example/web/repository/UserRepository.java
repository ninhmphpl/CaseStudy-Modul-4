package com.example.web.repository;

import com.example.web.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUsersByEmail(String email);
    boolean existsByEmail(String email);
    User findUserByEmailContaining(String email);


}
