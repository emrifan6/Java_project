package com.mahardhika.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mahardhika.webapplication.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

        int isValidUser = service.validateUser(name, password);

        if (isValidUser == 0) {
            model.put("errorMessage", "User tidak ditemukan");
            return "login";
        }
        else if(isValidUser == 1){
            model.put("errorMessage", "Password Salah");
            return "login";
        }
        else if(isValidUser == 2){
            model.put("errorMessage", "Akun Terkunci");
            return "login";
        }


        model.put("name", name);
        model.put("password", password);

        return "index";
    }

}