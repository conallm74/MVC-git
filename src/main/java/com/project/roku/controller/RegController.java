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
        if (theBindingResult.hasErrors()){
            return "register/registration-form";
        }
        // check if the new user already exists
        Users existing = userService.findByUserName(userName);
        if(existing != null){
            theModel.addAttribute("rokuUser", new TheNewUser());
            theModel.addAttribute("registrationError", "User is already registered");

            logger.warning("User name already exists");
            return "register/registration-form";
        }
        // create user account and store in the databse
        userService.save(theNewUser);
        logger.info("Successfully registered new user" + userName);
        session.setAttribute("user", theNewUser);

        // return to the confirmation page

        return "register/registration-confirmation";
    }

// more in pdf

}



















