package com.example.web.repository.company;

import com.example.web.model.Company;
import com.example.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends JpaRepository<Company,Long> {
    Company findByUser(User user);
}
