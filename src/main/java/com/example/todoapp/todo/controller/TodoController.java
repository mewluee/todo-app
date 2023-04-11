package com.example.todoapp.todo.controller;

import com.example.todoapp.todo.dto.ResponseDto;
import com.example.todoapp.todo.dto.TodoOneDto;
import com.example.todoapp.todo.service.TodoService;
import com.example.todoapp.todo.vo.TodoOne;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/v1/todolist")
@RestController
public class TodoController {
    //컨트롤러가 하는 기능
    //입력에 따라 행위 지정
    private TodoService todoService;

    //생성자 주입받기!
    //객체 주입은 2가지 방법이 있지.
    //service클래스에 @Service애너테이션이 없으면 스프링 컨테이너가 생성자 주입이 불가능.
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // "/"이거 안해도 매핑되나? -> ㅇㅇ!
    @PostMapping
    public ResponseEntity createTodoOne(@RequestBody TodoOneDto todoOneDto) {
        //로그 기능 만드는 방법이 뭐지? > 나중에 어드바이스로 만들수있을수도있어
        System.out.println("create");
        //Dto->vo (원래 매퍼가 하던건데 일단 매퍼없이 해보고 나중에 적용해보기)

        //vo객체의 요소에 접근하려면 get 메서드를 사용해야한다. > Lombok @Getter 애너테이션 써주기
        //왜? default는 패키지 내부만 적용되니까, 패키지가 달라서 접근이 안된다.

        //왜 of메서드는 static이어야하는거지?
        TodoOne newone = TodoOne.of(todoOneDto.getTitle(), todoOneDto.getTodo_order());
        //중복 검사할까 했는데, 생각해보니 이건 중복해도 돼.. 회원같은 게 아니니까.
        //똑같은 내용이든지간에 무조건 추가한다!
        //나중에 검사하고 싶으면 구현하면 될 듯.

        //서비스 메서드 -> stub 응답결과!
        TodoOne response = todoService.saveTodoOne(newone);

        //vo->dto (원래 매퍼가 하던거)
        ResponseDto responseDto = ResponseDto.of(response);

        return new ResponseEntity(responseDto, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity getTodoOne(@PathVariable int id) {
        System.out.println("getOne");

        //가져온 id가 유효한 값인지 확인이 필요하다.

        //서비스 메서드 -> stub 응답결과!
        TodoOne response = todoService.findById(id);

        //vo->dto
        ResponseDto responseDto = ResponseDto.of(response);


        return new ResponseEntity(responseDto,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodoList() {
        System.out.println("getList");

        //서비스 메서드 -> stub 응답결과!
        List<TodoOne> todoList=todoService.findAll();

        //vo->dto
        List<ResponseDto> responseDtos=new ArrayList<>();
        //이렇게 for문으로 처리하는게 맞나?
        for (TodoOne one : todoList) {
            responseDtos.add(ResponseDto.of(one));
        }

        return new ResponseEntity(responseDtos, HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    public ResponseEntity updateTodoOne(@PathVariable int id, @RequestBody TodoOneDto todoOneDto) {
        System.out.println("update");

        //여기부분 좀 이해안돼..

        //가져온 id가 유효한 값인지 확인이 필요하다.

        //dto->vo
        TodoOne newone = TodoOne.of(todoOneDto.getTitle(), todoOneDto.getTodo_order());
        newone.setId((long)id);

        //서비스 메서드(반환값:없음)
        todoService.updateTodoOne(newone);

        ResponseDto responseDto = ResponseDto.of(newone);

        return new ResponseEntity(responseDto, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteTodoList() {
        System.out.println("deleteList");

        //서비스 메서드(반환값:없음)
        todoService.deleteTodoList();

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodoOne(@PathVariable int id) {
        System.out.println("deleteOne");

        //가져온 id가 유효한 값인지 확인이 필요하다.

        //id에 해당하는 vo객체를 여기서 서비스 메서드 findById 로 가져오는게 맞나?
        //일단 이거 주석처리하고 서비스 메서드 deleteTodoOne 에서 내부적으로 처리할 예정
        //TodoOne newone = todoService.findById(id);

        //서비스 메서드(반환값:없음)
        todoService.deleteTodoOne(id);

        return new ResponseEntity(HttpStatus.OK);
    }

}
