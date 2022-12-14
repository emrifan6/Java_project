package web.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import web.model.entities.Password;
import web.model.entities.User;
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
    public String LoginValidation(ModelMap model, @RequestParam String user_id,
            @RequestParam String password) {
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
            model.put("message", myAppProperties.getError_user_locked());
            return "login";
        }
        if (validate_code != 3) {
            model.put("message", myAppProperties.getError_invalid_user());
            return "login";
        }
        HttpResponse<JsonNode> response = Unirest.get(
                "https://api.currencyfreaks.com/latest?apikey=4ec647aa8ffd42ed98711c52c95896b7&symbols=PKR,GBP,EUR,USD")
                .asJson();

        JSONObject myObj = response.getBody().getObject();

        DecimalFormat df = new DecimalFormat("0.00");

        model.put("date", myObj.get("date"));
        model.put("base", myObj.get("base"));
        model.put("pkr", df.format(Double.parseDouble(myObj.getJSONObject("rates").get("PKR").toString())));
        model.put("gbp", df.format(Double.parseDouble(myObj.getJSONObject("rates").get("GBP").toString())));
        model.put("eur", df.format(Double.parseDouble(myObj.getJSONObject("rates").get("EUR").toString())));
        model.put("usd", df.format(Double.parseDouble(myObj.getJSONObject("rates").get("USD").toString())));
        return "kurs";
        // return "welcome";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String ListUser(ModelMap model) {
        List<User> users = loginService.ListUser();
        System.out.println("********************************");
        System.out.println(users);
        System.out.println(users.get(0).getEmail());
        System.out.println(users.getClass().getName());
        model.put("datas", users);
        model.put("data_name", "Data User");
        return "showdata";
    }

    @RequestMapping(value = "/password", method = RequestMethod.GET)
    public String ListPassword(ModelMap model) {
        List<Password> password = loginService.ListPassword();
        System.out.println("********************************");
        System.out.println(password);
        System.out.println(password.get(0).getPassword());
        System.out.println(password.getClass().getName());
        model.put("datas", password);
        model.put("data_name", "Data Password");
        return "showdata";
    }
}