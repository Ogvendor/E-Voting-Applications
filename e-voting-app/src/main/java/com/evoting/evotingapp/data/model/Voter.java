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

import java.lang.annotation.Documented;
import java.util.UUID;

@Entity
@Data
@ToString
@AllArgsConstructor
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private String firstName;



    private String middleName;


    private String lastName;


//    @Email(message = "Email should be valid")
    private String email;


//    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}",
//            message = "password must contain at least 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String passWord;


    public Voter(){

    }

    public Voter(String email, String first_Name, String middle_Name, String last_Name, String pass_Word) {
        this.email =  email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passWord = passWord;
    }
}
