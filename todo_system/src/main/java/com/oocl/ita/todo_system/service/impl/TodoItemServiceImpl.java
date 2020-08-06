package com.oocl.ita.todo_system.service.impl;

import com.oocl.ita.todo_system.dto.TodoItemRequest;
import com.oocl.ita.todo_system.dto.TodoItemResponse;
import com.oocl.ita.todo_system.dto.mapper.TodoItemRequestMapper;
import com.oocl.ita.todo_system.dto.mapper.TodoItemResponseMapper;
import com.oocl.ita.todo_system.entity.TodoItem;
import com.oocl.ita.todo_system.repository.TodoItemRepository;
import com.oocl.ita.todo_system.service.TodoItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;

    public TodoItemServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @Override
    public List<TodoItemResponse> getTodoItems() {
        return TodoItemResponseMapper.todoItemsToTodoItemResponses(todoItemRepository.findAll());
    }

    public void deleteTodoItemById(Integer id) {
        todoItemRepository.deleteById(id);
    }

    @Override
    public TodoItemResponse addTodoItem(TodoItemRequest todoItemRequest) {
        TodoItem todoItem = TodoItemRequestMapper.toEntity(todoItemRequest);
        return TodoItemResponseMapper.todoItemsToTodoItemResponse(todoItemRepository.save(todoItem));
    }

    @Override
    public TodoItemResponse updateTodoItem(TodoItemRequest todoItemRequest, Integer id) {
        TodoItem todoItem = TodoItemRequestMapper.toEntity(todoItemRequest);
        todoItem.setId(id);
        return TodoItemResponseMapper.todoItemsToTodoItemResponse(todoItemRepository.save(todoItem));
    }
}
