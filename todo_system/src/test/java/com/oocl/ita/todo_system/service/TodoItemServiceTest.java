package com.oocl.ita.todo_system.service;

import com.oocl.ita.todo_system.dto.TodoItemResponse;
import com.oocl.ita.todo_system.entity.TodoItem;
import com.oocl.ita.todo_system.repository.TodoItemRepository;
import com.oocl.ita.todo_system.service.impl.TodoItemServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;


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
}
