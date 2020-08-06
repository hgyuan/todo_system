package com.oocl.ita.todo_system.integration;

import com.jayway.jsonpath.JsonPath;
import com.oocl.ita.todo_system.entity.TodoItem;
import com.oocl.ita.todo_system.repository.TodoItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class TodoItemsIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TodoItemRepository todoItemRepository;

    @BeforeEach
    public void initDb(){
        TodoItem todoItem = new TodoItem();
        todoItem.setText("123");
        todoItem.setMark(false);
        todoItemRepository.save(todoItem);
    }

    @Test
    public void should_return_1_todo_item_when_get_todo_items_given_1_todo_item() throws Exception {
        mockMvc.perform(get("/todoItems"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].text").value("123"));
    }

}
