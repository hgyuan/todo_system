package com.oocl.ita.todo_system.service;

import com.oocl.ita.todo_system.dto.TodoItemRequest;
import com.oocl.ita.todo_system.dto.TodoItemResponse;
import com.oocl.ita.todo_system.dto.mapper.TodoItemRequestMapper;
import com.oocl.ita.todo_system.dto.mapper.TodoItemResponseMapper;
import com.oocl.ita.todo_system.entity.TodoItem;
import com.oocl.ita.todo_system.repository.TodoItemRepository;
import com.oocl.ita.todo_system.service.impl.TodoItemServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoItemServiceTest {

    @Mock
    private TodoItemRepository todoItemRepository;

    @InjectMocks
    private TodoItemServiceImpl todoItemService;

    @Test
    void should_return_todo_item_response_dtos_when_get_todo_items() {
        //given
        List<TodoItem> todoItemList = new ArrayList();
        todoItemList.add(new TodoItem());
        when(todoItemRepository.findAll()).thenReturn(todoItemList);
        //when
        List<TodoItemResponse> result = todoItemService.getTodoItems();
        //then
        assertEquals(1, result.size());
    }

    @Test
    void should_when_delete_todo_item_by_id_given_1_id() {
        //given
        Integer id = 1;
        //when
        todoItemService.deleteTodoItemById(id);
        //then
        Mockito.verify(todoItemRepository, Mockito.times(1)).deleteById(any());
    }

    @Test
    void should_return_a_todo_item_response_when_add_todo_item_given_a_todo_item_request() {
        //given
        TodoItemRequest todoItemRequest = new TodoItemRequest( "123", false);
        TodoItem todoItem = TodoItemRequestMapper.toEntity(todoItemRequest);
        //when
        when(todoItemRepository.save(any())).thenReturn(todoItem);
        TodoItem resultTodoItem = todoItemService.addTodoItem(todoItem);
        TodoItemResponse todoItemResponse = TodoItemResponseMapper.todoItemsToTodoItemResponse(resultTodoItem);
        //then
        assertEquals("123", todoItemResponse.getText());
        assertEquals(false, todoItemResponse.getMark());
    }

    @Test
    void should_return_a_todo_item_response_when_update_todo_item_given_a_todo_item_request_a_id() {
        //given
        Integer id = 1;
        TodoItemRequest todoItemRequest = new TodoItemRequest( "123", false);
        TodoItem todoItem = TodoItemRequestMapper.toEntity(todoItemRequest);
        todoItem.setId(id);
        //when
        when(todoItemRepository.save(any())).thenReturn(todoItem);
        TodoItem resultTodoItem = todoItemService.updateTodoItem(todoItem, id);
        TodoItemResponse todoItemResponse = TodoItemResponseMapper.todoItemsToTodoItemResponse(resultTodoItem);
        //then
        assertEquals("123", todoItemResponse.getText());
        assertEquals(false, todoItemResponse.getMark());
    }
}
