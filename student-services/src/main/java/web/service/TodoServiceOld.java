package web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import web.model.Todo_old;

@Service
public class TodoServiceOld {
    private static List<Todo_old> todos = new ArrayList<Todo_old>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo_old(1, "user", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo_old(2, "user", "Learn Struts", new Date(), false));
        todos.add(new Todo_old(3, "user", "Learn Hibernate", new Date(),
                false));
    }

    public List<Todo_old> retrieveTodos(String user) {
        List<Todo_old> filteredTodos = new ArrayList<Todo_old>();
        for (Todo_old todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo_old(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo_old> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo_old todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}