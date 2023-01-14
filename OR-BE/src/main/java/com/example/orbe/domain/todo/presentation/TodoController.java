package com.example.orbe.domain.todo.presentation;

import com.example.orbe.domain.todo.presentation.dto.CreateTodoRequest;
import com.example.orbe.domain.todo.service.CompleteTodoService;
import com.example.orbe.domain.todo.service.CreateTodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hobbies/todo")
@RequiredArgsConstructor
public class TodoController {
    private final CreateTodoService createTodoService;
    private final CompleteTodoService completeTodoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createTodo(@RequestBody @Valid CreateTodoRequest request) {
        createTodoService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{todo-id}")
    public void completeTodo(@PathVariable("todo-id") Long todoId) {
        completeTodoService.execute(todoId);
    }


}
