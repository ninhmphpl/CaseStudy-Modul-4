package com.example.web.service;

import com.example.web.model.Customer;
import com.example.web.model.User;
import com.example.web.security.model.UserFormCreate;
import com.example.web.repository.CompanyRepository;
import com.example.web.repository.CustomerRepository;
import com.example.web.repository.UserRepository;
import com.example.web.security.model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CompanyRepository companyRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

    public User getUserLogging() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return findUserByEmail(authentication.getName());
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUsersByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserPrinciple(user);
    }

    public boolean checkEmailExist(String email) {
        return userRepository.existsByEmail(email);
    }

    public HttpStatus signIn(UserFormCreate userFormCreate) {
        try {
            // kiểm tra email trùng lặp
            if(checkEmailExist(userFormCreate.getEmail())) throw new Exception("Email exist");
            // lưu user vào trong database
            userRepository.save(userFormCreate.buildUser());
            // set lại user với thông tin đầy đủ trong database
            userFormCreate.setUser(userRepository.findUsersByEmail(userFormCreate.getEmail()));

            if (userFormCreate.getRole() == 2L) {
                Customer customer = userFormCreate.buildCustomer();
                customerRepository.save(customer);
                return HttpStatus.OK;
            } else if (userFormCreate.getRole() == 3L) {
                companyRepository.save(userFormCreate.buildCompany());
                return HttpStatus.OK;
            } else {
                return HttpStatus.BAD_GATEWAY;
            }
        } catch (Exception ex) {
            System.out.println("error:" + ex.getMessage());
            return HttpStatus.valueOf(415);
        }
    }
}
