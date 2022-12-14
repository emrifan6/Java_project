package web.service;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

@SpringBootTest
public class KursTest {

    @Test
    void KursTest() {
        System.out.println();
        System.out.println();
        System.out.println("Test Kurs API");
        HttpResponse<JsonNode> response = Unirest
                .get("https://api.currencyfreaks.com/latest?apikey=4ec647aa8ffd42ed98711c52c95896b7&symbols=PKR,GBP,EUR,USD")
                .asJson();
        // {"date":"2022-12-12
        //
        // 00:05:00+00","base":"USD","rates":{"PKR":"224.77000000000078","GBP":"0.8171","EUR":"0.9504","USD":"1.0"}}
        System.out.println("response = " +
                response.getBody().getClass().getSimpleName());
        System.out.println(response.getBody().getArray());
        System.out.println(response.getBody().getArray().getClass().getSimpleName());
        JSONObject myObj = response.getBody().getObject();
        System.out.println(myObj);
        System.out.println(myObj.keySet());
        System.out.println(myObj.length());
        System.out.println(myObj.getJSONObject("rates").length());
        System.out.println(myObj.getJSONObject("rates").keySet());
        for (String s : myObj.getJSONObject("rates").keySet()) {
            System.out.println(s);
        }
        System.out.println("date = " + myObj.get("date"));
        System.out.println("rates = " + myObj.getJSONObject("rates"));
        System.out.println("PKR = " + myObj.getJSONObject("rates").get("PKR"));
        System.out.println("PKR = " + myObj.getJSONObject("rates").get("PKR"));
        JSONObject rates = myObj.getJSONObject("rates");
        System.out.println(myObj.getJSONObject("rates").get("PKR").getClass().getSimpleName());
        double pkr = Double.parseDouble(myObj.getJSONObject("rates").get("PKR").toString());
        System.out.println(pkr);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(pkr));
        System.out.println();
        System.out.println();

    }
}
