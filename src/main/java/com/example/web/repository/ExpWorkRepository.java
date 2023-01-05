package com.example.web.repository;

import com.example.web.model.customer.ExpWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpWorkRepository extends JpaRepository<ExpWork,Long> {
}
