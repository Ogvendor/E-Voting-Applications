package com.evoting.evotingapp.payload.request;

import lombok.Data;

@Data
public class RegistrationRequest {

    private String first_name;
    private String middle_name;
    private String last_name;
    private String email;
    private String pass_word;
}
