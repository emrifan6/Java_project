package web.controller;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

// import kong.unirest.HttpResponse;
// import kong.unirest.JsonNode;
// import kong.unirest.Unirest;

@Controller
public class KursController {

    public static String[] addX(int n, String arr[], String x) {
        int i;
        String newarr[] = new String[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return newarr;
    }

    @RequestMapping(value = "/kurs", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        HttpResponse<JsonNode> response = Unirest.get(
                "https://api.currencyfreaks.com/latest?apikey=4ec647aa8ffd42ed98711c52c95896b7&symbols=PKR,GBP,EUR,USD")
                .asJson();

        JSONObject myObj = response.getBody().getObject();

        DecimalFormat df = new DecimalFormat("0.00");

        model.put("date", myObj.get("date"));
        model.put("base", myObj.get("base"));
        String[] data_key = {};
        String[] data_kurs = {};
        for (int i = 0; i < myObj.length(); i++) {
            String key_name = (String) myObj.getJSONObject("rates").names().get(i);
            data_key = addX(data_key.length, data_key, key_name);
            data_kurs = addX(data_kurs.length, data_kurs,
                    df.format(Double.parseDouble(myObj.getJSONObject("rates").get(key_name).toString())));
        }
        model.put("data_key", data_key);
        model.put("data_kurs", data_kurs);
        return "kurs";
    }
}
