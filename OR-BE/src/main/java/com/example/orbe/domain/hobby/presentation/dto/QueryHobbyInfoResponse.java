package com.example.orbe.domain.hobby.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryHobbyInfoResponse {
    private final List<TodoResponse> todoList;
    private final List<UserResponse> userList;

    @Getter
    @Builder
    public static class TodoResponse{
        private String name;
        private boolean isCompleted;
    }

    @Getter
    @Builder
    public static class UserResponse {
        private String name;
        private int completedTodoCount;
    }
}
