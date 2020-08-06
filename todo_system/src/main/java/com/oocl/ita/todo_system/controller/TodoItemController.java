package com.oocl.ita.todo_system.controller;

import com.oocl.ita.todo_system.dto.TodoItemRequest;
import com.oocl.ita.todo_system.dto.TodoItemResponse;
import com.oocl.ita.todo_system.service.TodoItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoItems")
public class TodoItemController {

    private final TodoItemService todoItemService;

    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping()
    public List<TodoItemResponse> getTodoItems() {
        return todoItemService.getTodoItems();
    }

    @PostMapping()
    public TodoItemResponse addTodoItem(@RequestBody TodoItemRequest todoItemRequest) {
        return todoItemService.addTodoItem(todoItemRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoItemById(@PathVariable Integer id) {
        todoItemService.deleteTodoItemById(id);
    }

    @PutMapping("/{id}")
    public TodoItemResponse updateTodoItemById(@PathVariable Integer id, @RequestBody TodoItemRequest todoItemRequest) {
        return todoItemService.updateTodoItem(todoItemRequest, id);
    }

}
