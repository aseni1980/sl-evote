package com.aseni.slevote.service;

import com.aseni.slevote.model.Member;
import com.aseni.slevote.model.Party;
import com.aseni.slevote.repository.MemberRepository;
import com.aseni.slevote.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService extends AbstractService<Member> {

    private static final int PAGE_SIZE = 5;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    protected JpaRepository<Member, Long> getRepository() {
        return memberRepository;
    }

    public Page<Member> getList(Integer pageNumber) {
        PageRequest pageRequest =
                PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "memberid");

        return getRepository().findAll(pageRequest);
    }

    public void update(Member entity) {
        Optional<Member> getEntityOpt = getRepository().findById(entity.getMemberid());
        Member getEntity = getEntityOpt.get();
        getRepository().save(entity);
    }


}
