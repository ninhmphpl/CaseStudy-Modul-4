package com.example.web.service.admin;

import com.example.web.repository.admin.UserRepository;
import com.example.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
