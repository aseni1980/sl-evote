package com.aseni.slevote.controller;

import com.aseni.slevote.model.Voter;
import com.aseni.slevote.service.UtilService;
import com.aseni.slevote.service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("voter")
public class VoterController {

    private VoterService voterService;

    @Autowired
    UtilService utilService;

    @Autowired
    public void setCustomerService(VoterService voterService) {
        this.voterService = voterService;
    }

    @GetMapping
    public String index() {
        return "redirect:/voter/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Voter> page = voterService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "voter/list";

    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("voter", new Voter());
        model.addAttribute("provinces", utilService.getProvinces());
        model.addAttribute("districts", utilService.getDistricts());
        return "voter/form";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("voter", voterService.get(id));
        model.addAttribute("provinces", utilService.getProvinces());
        model.addAttribute("districts", utilService.getDistricts());
        return "voter/form";

    }

    @PostMapping(value = "/save")
    public String save(Voter voter, final RedirectAttributes ra) {

        Voter save = voterService.save(voter);
        ra.addFlashAttribute("successFlash", "Voter saved successfully.");
        return "redirect:/voter";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        voterService.delete(id);
        return "redirect:/voter";

    }

}
