package com.evoting.evotingapp.payload.request;

import lombok.Data;

@Data
public class RegistrationRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String passWord;
}
