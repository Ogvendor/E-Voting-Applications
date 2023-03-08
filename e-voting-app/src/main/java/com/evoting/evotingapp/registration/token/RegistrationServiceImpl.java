package com.evoting.evotingapp.registration.token;

import com.evoting.evotingapp.data.model.Voter;
import com.evoting.evotingapp.data.repositories.VoterRepo;
import com.evoting.evotingapp.exceptions.RegistrationException;
import com.evoting.evotingapp.payload.request.RegistrationRequest;
import com.evoting.evotingapp.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    VoterRepo voterRepo;
    VoterService voterService;
    ConfirmationTokenService confirmationTokenService;

    @Autowired
    public RegistrationServiceImpl(VoterRepo voterRepo,VoterService voterService,ConfirmationTokenService confirmationTokenService){
        this.voterRepo = voterRepo;
        this.voterService = voterService;
        this.confirmationTokenService = confirmationTokenService;
    }


    @Override
    public String register(RegistrationRequest registrationRequest) throws RegistrationException {
        boolean emailExists = voterRepo.findByEmailIgnoreCase(registrationRequest.getEmail()).isPresent();
        if (emailExists)throw new RegistrationException("Email already exist");
        String token = voterService.createAccount(new Voter (
                registrationRequest.getEmail(),
                registrationRequest.getFirst_name(),
                registrationRequest.getMiddle_name(),
                registrationRequest.getLast_name(),
                registrationRequest.getPass_word()));

        return token;
    }
}
