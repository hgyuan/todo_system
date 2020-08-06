package com.oocl.ita.todo_system.dto.mapper;

import com.oocl.ita.todo_system.dto.TodoItemResponse;
import com.oocl.ita.todo_system.entity.TodoItem;

import java.util.List;
import java.util.stream.Collectors;

public class TodoItemResponseMapper {

    public static TodoItemResponse todoItemsToTodoItemResponse(TodoItem todoItem) {
        TodoItemResponse todoItemResponse = new TodoItemResponse();
        todoItemResponse.setId(todoItem.getId());
        todoItemResponse.setText(todoItem.getText());
        todoItemResponse.setMark(todoItem.getMark());
        return todoItemResponse;
    }

    public static List<TodoItemResponse> todoItemsToTodoItemResponses(List<TodoItem> todoItems) {
        return todoItems.stream().map(TodoItemResponseMapper::todoItemsToTodoItemResponse).collect(Collectors.toList());
    }

}
