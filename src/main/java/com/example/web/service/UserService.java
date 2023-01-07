package com.example.web.service;

import com.example.web.model.User;
import com.example.web.repository.UserRepository;
import com.example.web.security.model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findUserByEmail(String email){
        return userRepository.findUsersByEmail(email);
    }

    public String helloService(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "hello" + authentication.getName();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUsersByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserPrinciple(user);
    }
}
