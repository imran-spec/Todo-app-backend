package com.cfs.SpringBootP1.Contoller;

import com.cfs.SpringBootP1.Model.Todo;
import com.cfs.SpringBootP1.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/todos")
    public class TodoController {

        @Autowired
        private TodoService service;

        // ✅ GET all todos
        @GetMapping
        public List<Todo> getTodos() {
            return service.getAllTodos();
        }

        // ✅ POST add new todo
        @PostMapping
        public Todo addTodo(@RequestBody Todo todo) {
            return service.addTodo(todo);
        }

        // ✅ PUT update todo
        @PutMapping("/{id}")
        public Object updateTodo(@PathVariable int id, @RequestBody Todo todo) {
            Todo updated = service.updateTodo(id, todo);
            if (updated == null){
                return "Todo not found";
            }
            return updated;
        }

        // ✅ DELETE todo
        @DeleteMapping("/{id}")
        public String deleteTodo(@PathVariable int id) {
            return service.deleteTodo(id);
        }
    }
