package com.project.roku.controller;

import com.project.roku.entities.Users;
import com.project.roku.services.UserService;
import com.project.roku.user.TheNewUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegController {
    private Logger logger = Logger.getLogger(getClass().getName());

    private UserService userService;

    @Autowired
    public RegController(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel){
        theModel.addAttribute("rokuUser", new TheNewUser());
        return "register/registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("rokuUser") TheNewUser theNewUser,
            BindingResult theBindingResult,
            HttpSession session, Model theModel) {
        String userName = theNewUser.getUserName();
        logger.info("Registering..." + userName);

        // form validation
        if

    }

    // check if the new user already exists

    // Users existing = userService.findByUserName(userName);





}



















