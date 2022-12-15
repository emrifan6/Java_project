package web.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.JsonArray;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

@SpringBootTest
public class KursTest {

    // Function to add x in arr
    public static String[] addX(int n, String arr[], String x) {
        int i;
        String newarr[] = new String[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return newarr;
    }

    @Test
    void KursTest() {
        System.out.println();
        System.out.println();
        System.out.println("Test Kurs API");
        HttpResponse<JsonNode> response = Unirest
                .get("https://api.currencyfreaks.com/latest?apikey=4ec647aa8ffd42ed98711c52c95896b7&symbols=PKR,GBP,EUR,USD")
                .asJson();
        // System.out.println(Unirest.get(
        // "https://api.currencyfreaks.com/latest?apikey=4ec647aa8ffd42ed98711c52c95896b7&symbols=PKR,GBP,EUR,USD")
        // .asJson()
        // .getBody()
        // .getObject()
        // .getJSONObject("rates"));
        // {"date":"2022-12-12
        //
        // 00:05:00+00","base":"USD","rates":{"PKR":"224.77000000000078","GBP":"0.8171","EUR":"0.9504","USD":"1.0"}}
        System.out.println("response = " +
                response.getBody().getClass().getSimpleName());
        System.out.println(response.getBody().getArray());
        System.out.println(response.getBody().getArray().getClass().getSimpleName());
        System.out.println("Get array = " + response.getBody().getArray());
        // JSONArray data = response.getBody().getArray();
        // System.out.println("Index 0 = " + data.get(1));
        JSONObject myObj = response.getBody().getObject();

        System.out.println("myObj.names() = " + myObj.names());
        System.out.println("myObj.names().get(0) = " + myObj.names().get(0));
        System.out.println("myObj.length() = " + myObj.length());
        // String[] data_key = {};
        // for (int i = 0; i < myObj.length(); i++) {
        // data_key = addX(data_key.length, data_key, (String) myObj.names().get(i));
        // }
        // System.out.println("data_key = " + data_key[0]);
        // System.out.println("data_key = " + data_key[1]);
        // System.out.println("data_key = " + data_key[2]);
        System.out.println(myObj);
        System.out.println(myObj.keySet());
        System.out.println(myObj.length());
        // System.out.println("JSON Array = " + myObj.getJSONArray("rates"));
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
        // Getting languages JSON array from the JSON object

        String[] data_key = {};
        String[] data_kurs = {};
        for (int i = 0; i < myObj.length(); i++) {
            String key_name = (String) myObj.getJSONObject("rates").names().get(i);
            data_key = addX(data_key.length, data_key, key_name);
            data_kurs = addX(data_kurs.length, data_kurs, (String) myObj.getJSONObject("rates").get(key_name));
        }
        System.out.println("***DATA KEY***");
        for (String key : data_key) {
            System.out.println(key);
        }
        System.out.println("***DATA KURS***");
        for (String kurs : data_kurs) {
            System.out.println(kurs);
        }

        Map<String, String> kurs_map = new HashMap<String, String>();

        // method to add the key,value pair in hashmap
        // for (int i = 0; i < data_key.length; i++) {
        // kurs_map.put("value", data_kurs[i]);
        // kurs_map.put("key", data_key[i]);
        // }
        // System.out.println(kurs_map);

        System.out.println();
        System.out.println();

    }
}
