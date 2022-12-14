package web.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.model.entities.Todo;
import web.model.entities.User;
import web.repos.TodoRepository;

@Service
public class TodoServiceImpl {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> listAllTodo() {
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo FindByUserId(User user_id) {
        System.out.println("FindByUserId");
        Todo data = todoRepository.findByUserid(user_id);
        System.out.println("FindByUserId FINISH");
        return data;
    }

    public boolean InsertTodo(User user, String desc, LocalDate targetdate,
            boolean isdone) {
        Todo todoMod = new Todo(null, user, desc, targetdate, isdone);
        Todo output = new Todo();
        try {
            output = todoRepository.save(todoMod);
        } catch (Exception e) {
            return false;
        }
        if (output.getId() == null) {
            return false;
        }
        System.out.println("Succes INSERT data to todos table");
        return true;
    }

    public List<Todo> ListTodoByUser(User user_id) {
        return (List<Todo>) todoRepository.findByUserid(user_id);
    }
}
