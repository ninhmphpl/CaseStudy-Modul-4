package com.example.web.controller.ControllerAdmin;

import com.example.web.ServiceAdmin.AdminService;
import com.example.web.model.Company;
import com.example.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/admin")
@PropertySource("classpath:application.properties")
public class AdminController {
    @Autowired
    AdminService adminService;
    @GetMapping("/index")
    public ResponseEntity<List<Company>> findAll(){
        return new ResponseEntity<>(adminService.findAll() , HttpStatus.OK);
    }

}
