package com.evoting.evotingapp.controllers;

import com.evoting.evotingapp.payload.request.LoginRequest;
import com.evoting.evotingapp.services.VoterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    VoterService voterService;

    public LoginController(VoterService voterService){
        this.voterService =  voterService;
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
      var response =  voterService.login(loginRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
