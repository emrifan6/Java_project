package web.service;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.model.entities.User;
import web.service.impl.TodoServiceImpl;
import web.service.impl.UserServiceImpl;

@Service
public class TodoService {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private TodoServiceImpl todoServiceImpl;

    public boolean AddTodo(String user_id, String desc, LocalDate targdate,
            boolean isdone) {
        /*
         * Add todo code
         * true = insert data succes
         * false = insert data fail
         */

        // Check user_id in users table
        User user = (User) userServiceImpl.FindByUserId(user_id);
        List<User> user_list = new ArrayList<User>();
        user_list.add(user);

        if (user_list.get(0) == null) {
            // user_id not not found in users_table
            System.out.println("user_id not not found in users_table");
            return false;
        }

        user = (User) userServiceImpl.FindByUserId(user_id);
        System.out.println("AddTodo");
        boolean result = todoServiceImpl.InsertTodo(user, desc, targdate, isdone);
        if (result) {
            // succes insert data to todos table
            return true;
        }

        return false;
    }
}
