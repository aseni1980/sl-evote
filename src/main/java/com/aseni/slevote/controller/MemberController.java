package com.aseni.slevote.controller;

import com.aseni.slevote.model.Member;
import com.aseni.slevote.model.Party;
import com.aseni.slevote.service.MemberService;
import com.aseni.slevote.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("member")
public class MemberController {

    private MemberService memberService;
    private PartyService partyService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Autowired
    public void setPartyService(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping
    public String index() {
        return "redirect:/member/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Member> page = memberService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "member/list";

    }

    @GetMapping("/add")
    public String add(Model model) {
        List<Party> parties = partyService.getList();
        model.addAttribute("member", new Member());
        Map<Long,String> map = parties.stream()
                .collect(Collectors.toMap(Party::getPartyid, Party::getName));
        model.addAttribute("parties", parties);
        return "member/form";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("member", memberService.get(id));
        return "member/form";

    }

    @PostMapping(value = "/save")
    public String save(Member member, final RedirectAttributes ra) {
        Party refrech = partyService.get(member.getParty().getPartyid());
        member.setParty(refrech);
        Member save = memberService.save(member);
        ra.addFlashAttribute("successFlash", "Member saved successfully");
        return "redirect:/member";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        memberService.delete(id);
        return "redirect:/member";

    }

}
