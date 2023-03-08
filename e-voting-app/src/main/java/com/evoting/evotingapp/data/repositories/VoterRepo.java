package com.evoting.evotingapp.data.repositories;

import com.evoting.evotingapp.data.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VoterRepo extends JpaRepository<Voter, UUID> {
  Optional<Voter> findByEmailIgnoreCase(String email);
}
