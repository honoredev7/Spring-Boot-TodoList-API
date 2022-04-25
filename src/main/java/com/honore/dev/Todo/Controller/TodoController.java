package com.honore.dev.Todo.Controller;

import com.honore.dev.Todo.Entity.Todo;
import com.honore.dev.Todo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/todos")
    private List<Todo> findAllTodos() {
        return this.service.getTodos();
    }

    @PostMapping("/todo/new")
    private Todo createNewTodo(@RequestParam String text) {
        return this.service.createTodo(text);
    }

    @DeleteMapping("/todo/delete/{id}")
    public void deleteTodo(@RequestParam int id) {
        this.service.deleteTodo(id);
        return;
    }

    @GetMapping("/todo/complete/{id}")
    public boolean completeTodo(@RequestParam int id) {
        return this.completeTodo(id);
    }
}
