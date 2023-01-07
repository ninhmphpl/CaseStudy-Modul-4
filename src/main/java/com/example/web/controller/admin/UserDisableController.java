package com.example.web.controller.admin;

import com.example.web.model.User;
import com.example.web.model.admin.Status;
import com.example.web.repository.UserRepository;
import com.example.web.service.admin.UserDisableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/userDisable")
@CrossOrigin("*")
@PropertySource("classpath:application.properties")
public class UserDisableController {
    @Autowired
    UserDisableService admDisableService;
    @Autowired
    UserRepository userRepository;
    @PutMapping("/{id}/{status}")
    public ResponseEntity<?> activeBlockUser(@PathVariable Long id, @PathVariable Long status) {
        User user = userRepository.findById(id).get();
        user.setStatus(new Status(status , null));
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
