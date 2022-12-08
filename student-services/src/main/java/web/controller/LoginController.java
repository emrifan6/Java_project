package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.properties.AppProperties;
import web.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    AppProperties myAppProperties;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LoginValidation(ModelMap model, @RequestParam String user_id, @RequestParam String password) {
        /*
         * Login Validate Code
         * 0 = user_id not found
         * 1 = user_id found, wrong password
         * 2 = user_id found, user is lock
         * 3 = user_id found, correct password
         */
        int validate_code = loginService.ValidateLogin(user_id, password);
        System.out.println("validate_code = " + validate_code);
        if (validate_code == 2) {
            model.put("errorMessage", myAppProperties.getError_user_locked());
            return "login";
        }
        if (validate_code != 3) {
            model.put("errorMessage", myAppProperties.getError_invalid_user());
            return "login";
        }
        return "welcome";
    }

}