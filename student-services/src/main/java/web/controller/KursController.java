package web.controller;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

// import kong.unirest.HttpResponse;
// import kong.unirest.JsonNode;
// import kong.unirest.Unirest;

@Controller
public class KursController {

    @RequestMapping(value = "/kurs", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
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
    }
}
