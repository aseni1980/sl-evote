package com.aseni.slevote.service;

import com.aseni.slevote.model.Customers;
import com.aseni.slevote.model.Party;
import com.aseni.slevote.repository.CustomersRepository;
import com.aseni.slevote.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PartyService extends AbstractService<Party, Long> {

    @Autowired
    private PartyRepository partyRepository;

    @Override
    protected JpaRepository<Party, Long> getRepository() {
        return partyRepository;
    }

}
