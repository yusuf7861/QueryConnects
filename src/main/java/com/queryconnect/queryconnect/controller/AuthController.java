package com.queryconnect.queryconnect.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.queryconnect.queryconnect.domain.Users;
import com.queryconnect.queryconnect.service.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/query-connects")
    public String home()
    {
        return "home";
    }

    @GetMapping("/login")
    public String showLoginForm(@RequestParam(value = "logout", required = false) String logout, @RequestParam(value = "error", required = false) String error, Model model, RedirectAttributes redirectAttributes) {
        if (logout != null) {
            String message = "You have been successfully logged out.";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/login";
        }

        if(error != null)
        {
                model.addAttribute("error", "Invalid username or password. Please try again.");
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute Users user, Model model) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/"; // Redirect to dashboard or home page after successful login
        } catch (AuthenticationException e) {
            model.addAttribute("error", e);
            return "login";
        }
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute Users users, BindingResult result, Model model) {

        if(result.hasErrors())
        {
            return "register";
        }

        try {
            userService.registerUser(users);
            return "redirect:/login";
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
            return "register";
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("users", new Users());
        return "register";
    }

    @GetMapping("/logout")
    public String logout()
    {
        return "redirect:/login";
    }
}
