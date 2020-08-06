package com.oocl.ita.todo_system.service;

import com.oocl.ita.todo_system.dto.TodoItemResponse;
import com.oocl.ita.todo_system.entity.TodoItem;

import java.util.List;

public interface TodoItemService {
    List<TodoItemResponse> getTodoItems();
    void deleteTodoItemById(Integer id);
    TodoItem addTodoItem(TodoItem todoItem);
    TodoItem updateTodoItem(TodoItem todoItem, Integer id);
}
