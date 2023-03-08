package com.evoting.evotingapp.registration.token;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ConfirmationTokenTokenServiceImpl implements ConfirmationTokenService {

    ConfirmationRepository confirmationRepository;

    @Autowired
    public ConfirmationTokenTokenServiceImpl(ConfirmationRepository confirmationRepository){
        this.confirmationRepository = confirmationRepository;
    }
    @Override
    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
       confirmationRepository.save(confirmationToken);
    }

    @Override
    public Optional<ConfirmationToken> getConfirmationToken(String token) {
        return confirmationRepository.findByToken(token);
    }

    @Override
    public void deleteExpiredToken() {
        confirmationRepository.deleteConfirmationTokenByExpiredAfter(Instant.now());
    }

    @Override
    public void confirmedAt(String token) {
        confirmationRepository.setConfirmedAt(Instant.now(),token);
    }


}
