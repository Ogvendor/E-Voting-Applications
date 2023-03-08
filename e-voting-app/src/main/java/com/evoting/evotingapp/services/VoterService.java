package com.evoting.evotingapp.services;

import com.evoting.evotingapp.data.model.Voter;
import com.evoting.evotingapp.payload.request.LoginRequest;

import org.springframework.stereotype.Service;

@Service
public interface VoterService {
    String createAccount(Voter voter);

    String login(LoginRequest loginRequest);
}
