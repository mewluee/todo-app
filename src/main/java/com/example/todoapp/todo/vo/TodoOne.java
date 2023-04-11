package com.example.todoapp.todo.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoOne {

    //애너테이션 뭐 있었던 것 같은데
    Long id;
    String title;
    int todo_order;
    boolean completed;

    /*//기본 생성자
    public TodoOne(String title, int todo_order, boolean completed) {
        this.title = title;
        this.todo_order = todo_order;
        this.completed = completed;
    }*/

    //정적 팩토리 메서드
    public static TodoOne of(String title, int todo_order) {
        TodoOne todoOne = new TodoOne();
        todoOne.title=title;
        todoOne.todo_order=todo_order;
        todoOne.completed=false;

        return todoOne;
    }
}
