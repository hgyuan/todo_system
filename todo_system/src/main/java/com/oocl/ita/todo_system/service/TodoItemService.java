package com.oocl.ita.todo_system.service;

import com.oocl.ita.todo_system.dto.TodoItemRequest;
import com.oocl.ita.todo_system.dto.TodoItemResponse;
import com.oocl.ita.todo_system.entity.TodoItem;

import java.util.List;

public interface TodoItemService {
    List<TodoItemResponse> getTodoItems();
    void deleteTodoItemById(Integer id);
    TodoItemResponse addTodoItem(TodoItemRequest todoItemRequest);
    TodoItemResponse updateTodoItem(TodoItemRequest todoItemRequest, Integer id);
}
