package com.nofinish.ldvelh.model;

import lombok.Data;

//A tester avec autowired
@Data
public class Registration {

    private final String name;
    private final String username;
    private final String email;
    private final String password;
}
