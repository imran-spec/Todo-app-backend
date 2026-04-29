package com.cfs.SpringBootP1.Service;

import com.cfs.SpringBootP1.Model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
    public class TodoService {

        private final List<Todo> todos = new ArrayList<>();

        public List<Todo> getAllTodos() {
            return todos;
        }

        private int currentId = 1;

        public Todo addTodo(Todo todo) {
            todo.setId(currentId++);
            todos.add(todo);
            return todo;
        }

    public Todo updateTodo(int id, Todo updatedTodo) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                todo.setTitle(updatedTodo.getTitle());
                todo.setCompleted(updatedTodo.isCompleted());
                return todo;
            }
        }
        return null;
    }

    public String deleteTodo(int id) {
            boolean removed =
                    todos.removeIf(todo -> todo.getId() == id);
        return removed ? "Deleted" : "Todo not found";
    }
}

