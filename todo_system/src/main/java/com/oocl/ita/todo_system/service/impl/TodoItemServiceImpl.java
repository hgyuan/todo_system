package com.oocl.ita.todo_system.service.impl;

import com.oocl.ita.todo_system.dto.TodoItemResponse;
import com.oocl.ita.todo_system.repository.TodoItemRepository;
import com.oocl.ita.todo_system.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;

    public TodoItemServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @Override
    public List<TodoItemResponse> getTodoItems() {
        return new ArrayList<>(0);
    }
}
