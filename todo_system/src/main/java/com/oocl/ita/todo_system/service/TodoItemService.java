package com.oocl.ita.todo_system.service;

import com.oocl.ita.todo_system.dto.TodoItemResponse;

import java.util.List;

public interface TodoItemService {
    List<TodoItemResponse> getTodoItems();
}
