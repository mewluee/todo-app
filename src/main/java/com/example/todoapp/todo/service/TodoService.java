package com.example.todoapp.todo.service;

import com.example.todoapp.todo.repository.TodoRepository;
import com.example.todoapp.todo.vo.TodoOne;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoOne saveTodoOne(TodoOne todoOne) {
        System.out.println("service:saveTodoOne()");
        //repository에 데이터를 저장한다

        //stub 데이터
        TodoOne response=TodoOne.of("응답:"+todoOne.getTitle(), todoOne.getTodo_order());

        response.setId(1L);

        return response;
    }

    public TodoOne findById(long id) {
        //repository에서 데이터 검색해서 가져온다

        //stub 데이터
        TodoOne response=TodoOne.of("id:"+id+" 응답", 2);

        response.setId(2L);

        return response;

    }

    public List<TodoOne> findAll() {
        //repository에서 데이터를 다 가져온다

        //stub
        List<TodoOne> todoOnes = new ArrayList<>();

        TodoOne tdo1 = TodoOne.of("list 응답결과1", 3);
        tdo1.setId(3L);

        TodoOne tdo2 = TodoOne.of("list 응답결과2", 4);
        tdo2.setId(4L);

        todoOnes.add(tdo1);
        todoOnes.add(tdo2);

        return todoOnes;
    }

    public void updateTodoOne(TodoOne todoOne) {
        //repository에 해당 데이터를 저장한다

        //stub 데이터 없음
        //출력만 하자
        System.out.println("service > update");
    }

    public void deleteTodoList(){
        //repository에 있는 데이터를 모두 지운다.

        //stub 데이터 없음
        //출력만 하자
        System.out.println("service > delete list");
    }

    public void deleteTodoOne(int id) {
        //repository에 있는 id에 해당하는 데이터를 지운다.

        System.out.println("service > delete one");
    }

}
