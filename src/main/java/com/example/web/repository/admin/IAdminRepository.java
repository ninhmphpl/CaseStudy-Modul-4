package com.example.web.repository.admin;

import com.example.web.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAdminRepository extends JpaRepository<Company,Long > {
    List<Company> findAllByNameContaining(String name);
}
