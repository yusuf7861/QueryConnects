package com.queryconnect.queryconnect.controller;

import com.queryconnect.queryconnect.domain.EnquirySource;
import com.queryconnect.queryconnect.domain.Institute;
import com.queryconnect.queryconnect.domain.Users;
import com.queryconnect.queryconnect.dto.EnquiryCommand;
import com.queryconnect.queryconnect.repository.EnquirysourceRepository;
import com.queryconnect.queryconnect.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class EnquiryController {

    @Autowired
    InstituteRepository instituteRepository;

    @Autowired
    EnquirysourceRepository es;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal Users users, Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            String username = authentication.getName(); // Get the logged-in user's username
            model.addAttribute("username", username); // Add it to the model
        }
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
