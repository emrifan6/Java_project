package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.properties.AppProperties;
import web.service.RegisterService;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    AppProperties myAppProperties;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String Register(ModelMap model) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String RegisterValidation(ModelMap model, @RequestParam String user_id, @RequestParam String email,
            @RequestParam String password, @RequestParam String nomor_kartu,
            @RequestParam String nomor_hp) {
        /*
         * Register Validate Code
         * 0 = fail
         * 1 = user_id already in users table
         * 2 = succes registration
         */
        int validate_code = registerService.Registration(user_id, email, password,
                nomor_kartu, nomor_hp);
        System.out.println("validate_code = " + validate_code);
        if (validate_code == 1) {
            model.put("message", myAppProperties.getError_already_registered());
            return "register";
        }
        if (validate_code == 2) {
            model.put("message", myAppProperties.getSucces_registration());
        }
        return "login";
    }

    @RequestMapping(value = "/delete_user", method = RequestMethod.POST)
    public String DeleteUser(@RequestParam String user_id) {
        registerService.DeleteAccount(user_id);
        return "register";
    }

}
