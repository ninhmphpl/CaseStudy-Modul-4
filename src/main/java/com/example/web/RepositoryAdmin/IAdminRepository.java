package com.example.web.RepositoryAdmin;

import com.example.web.model.Company;
import com.example.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAdminRepository extends JpaRepository<Company,Long > {
    List<Company> findAllByNameContaining(String name);
}
