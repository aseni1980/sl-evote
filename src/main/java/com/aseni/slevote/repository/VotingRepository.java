package com.aseni.slevote.repository;

import com.aseni.slevote.model.Voting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingRepository extends JpaRepository<Voting, Long> {

}
