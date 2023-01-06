package com.example.web.service.admin;

import com.example.web.model.User;
import com.example.web.model.admin.Status;
import com.example.web.service.ICrudService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDisableService implements ICrudService <User, Long> {
    public void activeBlockUser(Long id, Status status) {

        findById(id).get().setStatus(status);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
    public Boolean checkDisable(Long id , Boolean status){
        if (
                status == true
        ){
            return status == false;
        }
        return status = true;
    }
}

