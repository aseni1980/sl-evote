package com.aseni.slevote.service;

import com.aseni.slevote.model.Member;
import com.aseni.slevote.model.ResultDto;
import com.aseni.slevote.model.Voting;
import com.aseni.slevote.repository.MemberRepository;
import com.aseni.slevote.repository.VotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResultService extends AbstractService<Voting> {

    private static final int PAGE_SIZE = 5;
    @Autowired
    private VotingRepository votingRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    protected JpaRepository<Voting, Long> getRepository() {
        return votingRepository;
    }


    public List<ResultDto> getResultList(){
        Map<String, ResultDto> resultDtoMap = getSortedResults();
        return resultDtoMap.values().stream().toList();
    }

    private Map<Long, Member> loadMemberMap() {
        return memberRepository.findAll().stream().collect(
                Collectors.toMap(Member::getMemberid, member -> member));

    }

    private Map<String, ResultDto> getSortedResults(){
        Map<String, ResultDto> resultMap = new HashMap<>();

        List<Voting> votingList= votingRepository.findAll();
        Map<Long, Member> memberMap = loadMemberMap();

        int totalVotes = votingList.size();
        Map<Long, List<Voting>> sortedVotes = votingList.stream().collect(
                Collectors.groupingBy(Voting::getMemberid));
        sortedVotes.forEach((key, value) -> {
            List<Voting> tmpVtLst = value;
            ResultDto newDto = new ResultDto();
            Member tmpMember = memberMap.get(key);
            newDto.setFullname(tmpMember.getFullname());
            newDto.setLogo_url(tmpMember.getParty().getLogo_url());
            newDto.setMemberid(key);
            newDto.setTotalVotes((long) totalVotes);
            newDto.setWonVotes((long) tmpVtLst.size());
            if(totalVotes> 0){
                newDto.setPercentage(String.valueOf((tmpVtLst.size()/totalVotes)*100));
            }
            resultMap.put(tmpMember.getFullname(), newDto);
        });
        return resultMap;
    }



}
