package web.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.TodoService;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;

    // private User userid;
    // private String desc;
    // private LocalDate targetdate;
    // private boolean isdone;

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public void AddTodo(@RequestParam String user_id, @RequestParam String desc,
            @RequestParam String targetdate,
            boolean isdone) {
        System.out.println("AddTodo******************************************************");
        ;
        System.out.println(user_id + desc + targetdate + isdone);
        LocalDate targetDate = LocalDate.parse(targetdate);
        boolean result = todoService.AddTodo(user_id, desc, targetDate, isdone);
        if (result) {
            System.out.println("Berhasil input data todos");
        }
    }
}
