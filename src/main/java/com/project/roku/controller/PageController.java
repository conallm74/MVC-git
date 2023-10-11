package com.project.roku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    // add a request mapping for doctors
    @GetMapping("/doctors")
    public String showDoctors(){
        return "doctors";
    }
}
