package com.example.web.controller.admin;

import com.example.web.model.User;
import com.example.web.model.admin.Status;
import com.example.web.service.admin.UserDisableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/userDisable")
@CrossOrigin("*")
@PropertySource("classpath:application.properties")
public class UserDisableController {
    @Autowired
    UserDisableService admDisableService;
    @PutMapping("/id={id}&status={status}")
    public ResponseEntity<User> activeBlockUser(@PathVariable Long id, @PathVariable Status status) {
        Optional<User> userOptional = admDisableService.findById(id);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        admDisableService.activeBlockUser(id, status);
        return new ResponseEntity<>(admDisableService.save(userOptional.get()), HttpStatus.OK);
    }

}
