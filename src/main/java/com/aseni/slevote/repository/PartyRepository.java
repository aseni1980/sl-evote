package com.aseni.slevote.repository;

import com.aseni.slevote.model.Customers;
import com.aseni.slevote.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

}
