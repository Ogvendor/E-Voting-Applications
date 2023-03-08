package com.evoting.evotingapp.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Entity
@Data
@ToString
@AllArgsConstructor
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @NotBlank
    private String first_name;

    @NotNull
    @NotBlank
    private String middle_name;

    @NotNull
    @NotBlank
    private String last_name;

    @NotNull
    @NotBlank
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank
    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}",
            message = "password must contain at least 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String pass_word;


    public Voter(){

    }

    public Voter(String email, String first_Name, String middle_Name, String last_Name, String pass_Word) {
        this.email =  email;
        this.first_name = first_Name;
        this.middle_name = middle_Name;
        this.last_name = last_Name;
        this.pass_word = pass_Word;
    }
}
