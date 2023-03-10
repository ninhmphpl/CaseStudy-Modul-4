package com.example.web.controller;

import com.example.web.model.Offer;
import com.example.web.model.User;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/admUser")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/searchEmail")
   public ResponseEntity<?>findByEmailName(@RequestParam ("searchEmail") String searchEmail){
       return new ResponseEntity<>(userService.findUserEmail(searchEmail) , HttpStatus.OK);
    }
}
