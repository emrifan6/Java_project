package com.demojstl.demo.controller;

import java.util.ArrayList;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {
    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        ArrayList<String> list = new ArrayList<>();

        list.add("Baseball");
        list.add("Basketball");
        list.add("Cricket");

        model.put("list", list);

        return "welcome_page";
    }
}