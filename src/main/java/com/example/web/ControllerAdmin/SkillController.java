package com.example.web.ControllerAdmin;

import com.example.web.RepositoryAdmin.SkillRepository;
import com.example.web.ServiceAdmin.SkillService;
import com.example.web.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    SkillService skillService;
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public ResponseEntity<List<Skill>> findAll(){
        return  new ResponseEntity<>(skillRepository.findAll(), HttpStatus.OK);
    }


}
