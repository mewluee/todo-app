package com.example.todoapp.todo.dto;

import com.example.todoapp.todo.vo.TodoOne;
import lombok.Getter;

@Getter
public class ResponseDto {

    long id;
    String title;
    int todoOrder;
    boolean completed;

    public static ResponseDto of(TodoOne todoOne) {
        ResponseDto responseDto=new ResponseDto();

        responseDto.id=todoOne.getId();
        responseDto.title=todoOne.getTitle();
        responseDto.todoOrder=todoOne.getTodo_order();
        responseDto.completed=todoOne.isCompleted();

        return responseDto;
    }

}
