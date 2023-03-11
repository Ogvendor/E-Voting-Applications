package com.evoting.evotingapp.controllers;

import com.evoting.evotingapp.data.model.Voter;
import com.evoting.evotingapp.exceptions.RegistrationException;
import com.evoting.evotingapp.payload.request.RegistrationRequest;
import com.evoting.evotingapp.registration.token.RegistrationService;
import com.evoting.evotingapp.services.VoterService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registration/")
public class RegistrationController {
    RegistrationService registrationService;
    VoterService voterService;

    @Autowired
    public RegistrationController(RegistrationService registrationService,VoterService voterService){
        this.registrationService = registrationService;
        this.voterService = voterService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest) throws RegistrationException, MessagingException {
        var response = registrationService.register(registrationRequest);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("all_voter")
    public ResponseEntity<?> getAllVoter(){
        List<Voter> voters = voterService.getAllVoter();
        return new ResponseEntity<>(voters,HttpStatus.OK);
    }
}
