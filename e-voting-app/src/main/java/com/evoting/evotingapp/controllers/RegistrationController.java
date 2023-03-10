package com.evoting.evotingapp.controllers;

import com.evoting.evotingapp.exceptions.RegistrationException;
import com.evoting.evotingapp.payload.request.RegistrationRequest;
import com.evoting.evotingapp.registration.token.RegistrationService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration/")
public class RegistrationController {
    RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest) throws RegistrationException, MessagingException {
        var response = registrationService.register(registrationRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("test")
    public ResponseEntity<?> test(){
        return new ResponseEntity<>("works",HttpStatus.OK);
    }
}
