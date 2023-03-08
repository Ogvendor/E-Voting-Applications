package com.evoting.evotingapp.registration.token;

import com.evoting.evotingapp.exceptions.RegistrationException;
import com.evoting.evotingapp.payload.request.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {

    String register(RegistrationRequest registrationRequest) throws RegistrationException;
}
