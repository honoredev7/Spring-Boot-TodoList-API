package com.honore.dev.Todo.Service;

import com.honore.dev.Todo.Entity.Todo;
import com.honore.dev.Todo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> getTodos() {
        return this.repository.findAll();
    }

    public Todo createTodo(String text) {
        Todo todo = new Todo();
        todo.setText(text);
        return todo;
    }

    public void deleteTodo(int id) {
        this.repository.deleteById(id);
        return;
    }

    public boolean completeTodo(int id) {
        Todo existingTodo = this.repository.getById(id);
        existingTodo.setComplete(!existingTodo.isComplete());
        return existingTodo.isComplete();
    }
}
