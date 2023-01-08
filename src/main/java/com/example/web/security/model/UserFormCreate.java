package com.example.web.security.model;

import com.example.web.model.*;
import com.example.web.model.admin.Status;
import com.example.web.model.customer.City;
import com.example.web.model.customer.Education;
import com.example.web.model.customer.ExpWork;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFormCreate {
    private String email;
    private String password;
    private Long role;
    private String phoneNumber;
    private String name;
    private User user;
        /**
         * status{
         * 1: Open
         * 2: Block
         * 3: Wait Apply
         * }
         **/
    private Status backStatus(Long ruleId){
        if (ruleId == 1L){ //ROLE_ADMIN
            return new Status(1L, null); // Open
        }
        if (ruleId == 2L){ // ROLE_CUSTOMER
            return new Status(1L, null); // Open
        }
        if (ruleId == 3L){ // ROLE_COMPANY
            return new Status(3L, null); // Wait Apply
        }
        return null;
    }
    // tạo 1 user và lưu nó vào trong data base, đồng thời gán lại user từ tong database
    public User buildUser() throws Exception {
        return user = new User(null,email,password,new Role(role, null), backStatus(role));
    }
    public Customer buildCustomer(){
        return new Customer(null, name, LocalDate.now(),
                new Education(1L,null),
                new ExpWork(1L, null),
                phoneNumber,
                new Gender(1L,null),
                user,
                new ArrayList<>(),
                new City(1L, null));
    }
    public Company buildCompany(){
        return new Company(null,name,user,phoneNumber,null,null,new ArrayList<>());
    }


}
