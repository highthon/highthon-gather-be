package com.example.orbe.domain.todo.facade;

import com.example.orbe.domain.todo.entity.Todo;
import com.example.orbe.domain.todo.entity.repository.TodoRepository;
import com.example.orbe.domain.todo.exception.TodoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TodoFacade {
    private final TodoRepository todoRepository;

    public Todo findTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> TodoNotFoundException.EXCEPTION);
    }
}
