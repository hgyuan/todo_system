package com.oocl.ita.todo_system.dto;

public class TodoItemRequest {

    private String text;

    private Boolean mark;

    public TodoItemRequest(){}

    public TodoItemRequest(String text, Boolean mark) {
        this.text = text;
        this.mark = mark;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getMark() {
        return mark;
    }

    public void setMark(Boolean mark) {
        this.mark = mark;
    }



}
