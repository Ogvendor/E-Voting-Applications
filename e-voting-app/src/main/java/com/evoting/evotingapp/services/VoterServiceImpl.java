package com.evoting.evotingapp.services;

import com.evoting.evotingapp.data.model.Voter;
import com.evoting.evotingapp.data.repositories.VoterRepo;
import com.evoting.evotingapp.payload.request.LoginRequest;
import com.evoting.evotingapp.registration.token.ConfirmationToken;
import com.evoting.evotingapp.registration.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class VoterServiceImpl implements VoterService {

     VoterRepo voterRepo;

     ConfirmationTokenService confirmationTokenService;


     @Autowired
    public VoterServiceImpl(VoterRepo voterRepo,ConfirmationTokenService confirmationTokenService){
        this.voterRepo = voterRepo;
        this.confirmationTokenService = confirmationTokenService;
    }
    @Override
    public String createAccount(Voter voter) {
        voterRepo.save(voter);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                Instant.now(),
                Instant.now(),
                Instant.now(),
                voter
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    @Override
    public String login(LoginRequest loginRequest) throws RuntimeException {
        Optional<Voter> voter = voterRepo.findByEmailIgnoreCase(loginRequest.getEmail());
        if (voter.isPresent()){
            if (voter.get().getEmail().equalsIgnoreCase(loginRequest.getEmail()) && voter.get().getPassWord().equalsIgnoreCase(loginRequest.getPass_word())){
                return "Success_full";
            }else {
                return "Incorrect email or password";
            }
        }
        throw new RuntimeException("");
    }


}
