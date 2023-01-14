package com.example.orbe.domain.todo.service;

import com.example.orbe.domain.hobby.domain.Hobby;
import com.example.orbe.domain.hobby.domain.repository.UserHobbyRepository;
import com.example.orbe.domain.hobby.facade.HobbyFacade;
import com.example.orbe.domain.todo.entity.Todo;
import com.example.orbe.domain.todo.entity.repository.TodoRepository;
import com.example.orbe.domain.todo.exception.NoAuthorityException;
import com.example.orbe.domain.todo.presentation.dto.CreateTodoRequest;
import com.example.orbe.domain.user.domain.User;
import com.example.orbe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateTodoService {
    private final TodoRepository todoRepository;
    private final HobbyFacade hobbyFacade;
    private final UserFacade userFacade;
    private final UserHobbyRepository userHobbyRepository;

    @Transactional
    public void execute(CreateTodoRequest request) {
        User user = userFacade.getCurrentUser();
        Hobby hobby = hobbyFacade.findById(request.getHobbyId());

        if(!userHobbyRepository.existsByHobbyAndUser(hobby, user)) {
            throw NoAuthorityException.EXCEPTION;
        }

        todoRepository.save(
                Todo.builder()
                        .content(request.getContent())
                        .hobby(hobby)
                        .build()
        );
    }
}
