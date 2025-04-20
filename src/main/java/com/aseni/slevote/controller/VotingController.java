package com.aseni.slevote.controller;

import com.aseni.slevote.model.Member;
import com.aseni.slevote.model.Party;
import com.aseni.slevote.model.Voting;
import com.aseni.slevote.service.MemberService;
import com.aseni.slevote.service.VotingService;
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
@RequestMapping("voting")
public class VotingController {

    private VotingService votingService;

    @Autowired
    private MemberService memberService;

    @Autowired
    public void setVotingService(VotingService votingService) {
        this.votingService = votingService;
    }

    @GetMapping
    public String index() {
        return "redirect:/voting/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Voting> page = votingService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "voting/list";

    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("voting", new Voting());
        List<Member> memberList = memberService.getMembersList();
//        Map<Long,Member> map = memberList.stream()
//                .collect(Collectors.toMap(Party::getPartyid, Party::getName));
        model.addAttribute("members", memberList);
        return "voting/form";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("voting", votingService.get(id));
        return "voting/form";

    }

    @PostMapping(value = "/save")
    public String save(Voting voting, final RedirectAttributes ra) {

        Voting save = votingService.save(voting);
        ra.addFlashAttribute("successFlash", "Party saved successfully.");
        return "redirect:/voting";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        votingService.delete(id);
        return "redirect:/voting";

    }

}
