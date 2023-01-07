package com.example.web.security.security.jwt;

import lombok.Data;

@Data
public class JwtResponse {
    private Long id;
    private String token;
    private String type;
    private String email;
    private String role;

    public JwtResponse(Long id, String token, String email, String role) {
        this.id = id;
        this.token = token;
        this.type = "Bearer ";
        this.email = email;
        this.role = role;
    }
}
