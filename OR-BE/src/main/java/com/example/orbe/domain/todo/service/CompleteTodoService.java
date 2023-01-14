package com.example.orbe.domain.todo.service;

import com.example.orbe.domain.todo.entity.CompletedTodo;
import com.example.orbe.domain.todo.entity.Todo;
import com.example.orbe.domain.todo.entity.repository.CompletedTodoRepository;
import com.example.orbe.domain.todo.facade.TodoFacade;
import com.example.orbe.domain.user.domain.User;
import com.example.orbe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CompleteTodoService {
    private final CompletedTodoRepository completedTodoRepository;
    private final UserFacade userFacade;
    private final TodoFacade todoFacade;

    @Transactional
    public void execute(Long todoId) {
        User user = userFacade.getCurrentUser();

        Todo todo = todoFacade.findTodoById(todoId);

        completedTodoRepository.save(
                new CompletedTodo(todo, user, todo.getHobby().getId())
        );
    }
}
