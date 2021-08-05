package com.nofinish.ldvelh.controller;

import com.nofinish.ldvelh.model.Registration;
import com.nofinish.ldvelh.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;


    public String register(RequestBody Registration request) {
        return registrationService.register(request);

    }
}
