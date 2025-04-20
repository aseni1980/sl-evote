package com.aseni.slevote.controller;

import com.aseni.slevote.model.Member;
import com.aseni.slevote.model.Voting;
import com.aseni.slevote.service.MemberService;
import com.aseni.slevote.service.ResultService;
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

@Controller
@RequestMapping("result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping
    public String index() {
        return "redirect:/result/list";
    }

    @GetMapping(value = "/list")
    public String list(Model model) {

        model.addAttribute("results", resultService.getResultList());
        return "result/index";

    }

}
