package com.aseni.slevote.service;

import com.aseni.slevote.model.Customers;
import com.aseni.slevote.model.Member;
import com.aseni.slevote.model.Party;
import com.aseni.slevote.repository.CustomersRepository;
import com.aseni.slevote.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyService extends AbstractService<Party> {

    private static final int PAGE_SIZE = 5;
    @Autowired
    private PartyRepository partyRepository;

    @Override
    protected JpaRepository<Party, Long> getRepository() {
        return partyRepository;
    }

    public Page<Party> getList(Integer pageNumber) {
        PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "partyid");

        return getRepository().findAll(pageRequest);
    }

    public List<Party> getList() {
        return getRepository().findAll();
    }

    public void update(Party entity) {
        Optional<Party> getEntityOpt = getRepository().findById(entity.getPartyid());
        Party getEntity = getEntityOpt.get();
        getRepository().save(entity);
    }
}
