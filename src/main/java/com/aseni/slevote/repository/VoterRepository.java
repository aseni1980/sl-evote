package com.aseni.slevote.repository;

import com.aseni.slevote.model.Party;
import com.aseni.slevote.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {

}
