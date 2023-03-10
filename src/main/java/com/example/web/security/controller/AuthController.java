package com.example.web.security.controller;

import com.example.web.model.User;
import com.example.web.security.model.UserFormCreate;
import com.example.web.security.security.jwt.JwtResponse;
import com.example.web.security.security.jwt.JwtService;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findUserByEmail(user.getEmail());
        JwtResponse response  = new JwtResponse(currentUser.getId(),
                jwt, currentUser.getEmail(), currentUser.getRole().getName());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/singIn")
    public ResponseEntity<?> signIn(@RequestBody UserFormCreate userFormCreate){
        userFormCreate.setPassword(passwordEncoder.encode(userFormCreate.getPassword()));
        return new ResponseEntity<>(userService.signIn(userFormCreate));
    }

    @GetMapping("/hello")
    public ResponseEntity<User> hello() {
        return new ResponseEntity<>(userService.getUserLogging(), HttpStatus.OK);
    }
}
