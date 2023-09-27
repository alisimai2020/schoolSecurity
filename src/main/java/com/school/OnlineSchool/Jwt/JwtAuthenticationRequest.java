package com.school.OnlineSchool.Jwt;

import lombok.Data;

@Data
public class JwtAuthenticationRequest {

    private String email;

    private String password;

    // private String role;
}
