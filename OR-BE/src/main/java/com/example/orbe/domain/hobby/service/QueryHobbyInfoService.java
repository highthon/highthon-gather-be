package com.example.orbe.domain.hobby.service;

import com.example.orbe.domain.hobby.domain.Hobby;
import com.example.orbe.domain.hobby.facade.HobbyFacade;
import com.example.orbe.domain.hobby.presentation.dto.QueryHobbyInfoResponse;
import com.example.orbe.domain.todo.entity.repository.CompletedTodoRepository;
import com.example.orbe.domain.user.domain.User;
import com.example.orbe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryHobbyInfoService {
    private final HobbyFacade hobbyFacade;
    private final UserFacade userFacade;

    private final CompletedTodoRepository completedTodoRepository;

    @Transactional(readOnly = true)
    public QueryHobbyInfoResponse execute(Long hobbyId) {
        Hobby hobby = hobbyFacade.findById(hobbyId);
        User user = userFacade.getCurrentUser();

        List<QueryHobbyInfoResponse.TodoResponse> todoResponseList = hobby.getTodoList().stream()
                .map(
                        t -> QueryHobbyInfoResponse.TodoResponse.builder()
                                .name(t.getContent())
                                .isCompleted(completedTodoRepository.existsByUserAndTodo(user, t))
                                .build()
                ).toList();

        List<QueryHobbyInfoResponse.UserResponse> userResponseList = hobby.getUserHobbyList().stream()
                .map(
                        u -> QueryHobbyInfoResponse.UserResponse.builder()
                                .name(u.getUser().getName())
                                .completedTodoCount(completedTodoRepository.findAllByHobbyId(hobby.getId()).stream()
                                        .filter(c-> c.getUser().equals(u.getUser())).toList().size())
                                .build()
                )
                .toList();

        return new QueryHobbyInfoResponse(todoResponseList, userResponseList);


    }
}
