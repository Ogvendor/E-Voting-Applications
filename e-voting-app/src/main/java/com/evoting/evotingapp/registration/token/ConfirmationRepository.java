package com.evoting.evotingapp.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConfirmationRepository extends JpaRepository<ConfirmationToken, UUID> {

    Optional<ConfirmationToken> findByToken(String token);

    void deleteConfirmationTokenByExpiredAfter(Instant currentTime);

    @Modifying
    @Query("UPDATE ConfirmationToken confirmationToken " +
            "SET confirmationToken.confirmedAt = ?1 " +
            "WHERE confirmationToken.token = ?2")
    void setConfirmedAt(Instant now,String confirmationToken);


}
