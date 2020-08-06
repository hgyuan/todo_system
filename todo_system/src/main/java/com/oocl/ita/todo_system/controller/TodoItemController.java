package com.oocl.ita.todo_system.controller;

import com.oocl.ita.todo_system.dto.TodoItemResponse;
import com.oocl.ita.todo_system.service.TodoItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todoItems")
public class TodoItemController {

    private final TodoItemService todoItemService;

    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping()
    public List<TodoItemResponse> getTodoItems(){
        return todoItemService.getTodoItems();
    }


}
