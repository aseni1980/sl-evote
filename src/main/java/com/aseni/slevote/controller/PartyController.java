package com.aseni.slevote.controller;

import com.aseni.slevote.model.Customers;
import com.aseni.slevote.model.Party;
import com.aseni.slevote.service.CustomersService;
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

@Controller
@RequestMapping("party")
public class PartyController {

    private PartyService partyService;

    @Autowired
    public void setCustomerService(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping
    public String index() {
        return "redirect:/party/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Party> page = partyService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "party/list";

    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("party", new Party());
        return "party/form";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("customer", partyService.get(id));
        return "party/form";

    }

    @PostMapping(value = "/save")
    public String save(Party party, final RedirectAttributes ra) {

        Party save = partyService.save(party);
        ra.addFlashAttribute("successFlash", "Cliente foi salvo com sucesso.");
        return "redirect:/party";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        partyService.delete(id);
        return "redirect:/party";

    }

}
