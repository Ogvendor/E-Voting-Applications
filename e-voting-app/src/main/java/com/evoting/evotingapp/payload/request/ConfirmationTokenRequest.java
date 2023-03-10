package com.evoting.evotingapp.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConfirmationTokenRequest {

    @NotNull
    private String token;

    private String email;
}
