package com.khay.CRM.controllers;

import com.khay.CRM.models.Customer;
import com.khay.CRM.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/customer")
public class CustomerController {


    private final CustomerRepository repository;
    private final PasswordEncoder encoder;

    @Autowired
    public CustomerController(CustomerRepository repository, PasswordEncoder encoder){
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/")
    public String showIndexPage(){
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login-page";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model){
        Customer customer = new Customer();
        model.addAttribute("theCustomer",customer);
        return "register-page";
    }

    @PostMapping("/confirm")
    public String handleRegister(@ModelAttribute("theCustomer") Customer customer)
    {
        customer.setPassword(encoder.encode(customer.getPassword()));
        repository.save(customer);
        System.out.println(customer);
        return "login-page";
    }

    @GetMapping("/home")
    public String homePage(){
        return "home";
    }


}
