package com.aseni.slevote.repository;

import com.aseni.slevote.model.Member;
import com.aseni.slevote.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
