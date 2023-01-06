package com.example.web.service;

import com.example.web.model.Skill;
import com.example.web.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SkillService implements ICrudService<Skill,Long>{
        @Autowired
        SkillRepository skillRepository;
        @Override
        public List<Skill> findAll() {
            return skillRepository.findAll();
        }

        @Override
        public Optional<Skill> findById(Long id) {
            return skillRepository.findById(id);
        }

        @Override
        public Skill save(Skill skill) {
            return skillRepository.save(skill);
        }

        @Override
        public void delete(Long id) {
            skillRepository.deleteById(id);

    }
}
