package com.evoting.evotingapp.registration.token;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ConfirmationTokenService {

    void saveConfirmationToken(ConfirmationToken confirmationToken);

    Optional<ConfirmationToken> getConfirmationToken(String token);

    void deleteExpiredToken();

    void confirmedAt(String token);
}
