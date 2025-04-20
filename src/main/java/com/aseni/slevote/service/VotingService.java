package com.aseni.slevote.service;

import com.aseni.slevote.model.Voting;
import com.aseni.slevote.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotingService extends AbstractService<Voting> {

    private static final int PAGE_SIZE = 5;
    @Autowired
    private VotingRepository votingRepository;

    @Override
    protected JpaRepository<Voting, Long> getRepository() {
        return votingRepository;
    }

    public Page<Voting> getList(Integer pageNumber) {
        PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "votingid");

        return getRepository().findAll(pageRequest);
    }

    public void update(Voting entity) {
        Optional<Voting> getEntityOpt = getRepository().findById(entity.getVotingid());
        Voting getEntity = getEntityOpt.get();
        getRepository().save(entity);
    }


}
