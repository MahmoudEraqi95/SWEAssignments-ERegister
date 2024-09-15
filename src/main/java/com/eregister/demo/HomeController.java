package com.eregister.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/eregistrar/home")
    public String homePage(Model model) {
        return "home";
    }
}
