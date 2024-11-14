package com.queryconnect.queryconnect.controller;

import com.queryconnect.queryconnect.domain.Institute;
import com.queryconnect.queryconnect.repository.InstituteRepository;
import com.queryconnect.queryconnect.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InstituteController {

    @Autowired
    InstituteRepository instituteRepository;

    @Autowired
    CommonService commonService;

    @GetMapping("/institute-form")
    public String form(Model model)
    {
        model.addAttribute("cmd", new Institute());
        return "institute-form";
    }

    @RequestMapping ("/save-institute")
    public String save(@ModelAttribute Institute inst)
    {
        inst.getContact().setName(inst.getName());  // set the contact name as institute name
        commonService.saveInstitute(inst);
        return "redirect:/institute-list";
    }

    @GetMapping("/institute-list")
    public String list(Model model)
    {
//        model.addAttribute("instituteList", instituteRepository.findAll());
        model.addAttribute("instituteList", instituteRepository.getInstList());
        return "institute-list";
    }
}

