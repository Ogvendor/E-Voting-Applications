package com.evoting.evotingapp.registration.token;

import com.evoting.evotingapp.data.model.Voter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String token;

    private Instant createdAt;

    private Instant expired;

    private Instant confirmedAt;

    @ManyToOne
    @JoinColumn(name = "voter_id", referencedColumnName = "id")
    private Voter voter;


    public ConfirmationToken(String token, Instant createdAt, Instant expired, Instant confirmedAt, Voter voter) {
        this.token = token;
        this.createdAt = createdAt;
        this.expired = expired;
        this.confirmedAt = confirmedAt;
        this.voter = voter;
    }
}
