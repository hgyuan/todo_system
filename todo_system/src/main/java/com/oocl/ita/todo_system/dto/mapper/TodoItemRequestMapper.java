package com.oocl.ita.todo_system.dto.mapper;

import com.oocl.ita.todo_system.dto.TodoItemRequest;
import com.oocl.ita.todo_system.entity.TodoItem;

public class TodoItemRequestMapper {
    public static TodoItem toEntity(TodoItemRequest todoItemRequest){
        TodoItem todoItem = new TodoItem();
        todoItem.setText(todoItemRequest.getText());
        todoItem.setMark(todoItemRequest.getMark());
        return todoItem;
    }
}
