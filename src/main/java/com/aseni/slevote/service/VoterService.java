package com.aseni.slevote.service;

import com.aseni.slevote.model.Party;
import com.aseni.slevote.model.Voter;
import com.aseni.slevote.repository.PartyRepository;
import com.aseni.slevote.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterService extends AbstractService<Voter> {

    private static final int PAGE_SIZE = 5;
    @Autowired
    private VoterRepository voterRepository;

    @Override
    protected JpaRepository<Voter, Long> getRepository() {
        return voterRepository;
    }

    public Page<Voter> getList(Integer pageNumber) {
        PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "voterid");

        return getRepository().findAll(pageRequest);
    }

    public List<Voter> getList() {
        return getRepository().findAll();
    }

    public void update(Voter entity) {
        Optional<Voter> getEntityOpt = getRepository().findById(entity.getVoterid());
        Voter getEntity = getEntityOpt.get();
        getRepository().save(entity);
    }
}
