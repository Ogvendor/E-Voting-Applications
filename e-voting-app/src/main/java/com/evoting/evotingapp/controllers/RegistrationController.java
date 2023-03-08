package com.evoting.evotingapp.controllers;

import com.evoting.evotingapp.exceptions.RegistrationException;
import com.evoting.evotingapp.payload.request.RegistrationRequest;
import com.evoting.evotingapp.registration.token.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RegistrationController {
    RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @PostMapping("/")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest) throws RegistrationException {
        registrationService.register(registrationRequest);
        return new ResponseEntity<>(registrationRequest,HttpStatus.OK);
    }
}
