package com.example.todoapp.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //dto->vo 역직렬화시 set메서드 사용
public class TodoOneDto {

    String title;
    int todo_order;
    boolean completed;


}
