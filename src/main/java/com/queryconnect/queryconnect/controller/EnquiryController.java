package com.queryconnect.queryconnect.controller;

import com.queryconnect.queryconnect.domain.EnquirySource;
import com.queryconnect.queryconnect.domain.Institute;
import com.queryconnect.queryconnect.dto.EnquiryCommand;
import com.queryconnect.queryconnect.repository.EnquirysourceRepository;
import com.queryconnect.queryconnect.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EnquiryController {

    @Autowired
    InstituteRepository instituteRepository;

    @Autowired
    EnquirysourceRepository es;

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("cmd", new EnquiryCommand());
        return "/index";
    }

    @ModelAttribute("instituteList")
    public List<Institute> getInstituteList()
    {
        return instituteRepository.findAll();
    }

    @ModelAttribute("sourceList")
    public List<EnquirySource> getSourceList()
    {
        return es.findAll();
    }
}
