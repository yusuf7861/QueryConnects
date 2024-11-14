package com.queryconnect.queryconnect.controller;

import com.queryconnect.queryconnect.domain.EnquirySource;
import com.queryconnect.queryconnect.repository.EnquirysourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EnquirySourceController {

    @Autowired
    EnquirysourceRepository enquirysourceRepository;


    @RequestMapping("/sources")
    public String enquirySources(Model model)
    {
        EnquirySource cmd = new EnquirySource();
        model.addAttribute("cmd", cmd);
        return "sources";
    }

    @GetMapping("/save-enquiry-source")
    public String save(@ModelAttribute EnquirySource es)
    {
        enquirysourceRepository.save(es);
        return "redirect:/sources";
    }

    @RequestMapping ("/enquiry-source-delete/{id}")
    public String delete(@PathVariable Long id)
    {
        enquirysourceRepository.deleteById(id);
        return "redirect:/sources";
    }

    @GetMapping("/enquiry-source-edit/{id}")
    public String edit(@PathVariable Long id, Model model)
    {
        EnquirySource cmd = enquirysourceRepository.findById(id).get();
        model.addAttribute("cmd", cmd);
        return "sources";
    }

    @ModelAttribute("enquirySourceList")
    public List<EnquirySource> getEnquirySourceList()
    {
        return enquirysourceRepository.findAll();
    }

    @GetMapping("enq-list")
    public String enquiryList(@RequestParam(required = false) Long instId, Model model)
    {
        model.addAttribute("enquiryList", enquirysourceRepository.getEnquiryDTOList(instId));
        return "enq-list";
    }
}
