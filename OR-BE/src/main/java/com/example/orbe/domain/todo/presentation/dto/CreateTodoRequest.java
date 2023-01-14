package com.example.orbe.domain.todo.presentation.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateTodoRequest {

    @NotNull(message = "content는 null일 수 없습니다.")
    private String content;

    @NotNull(message = "hobby_id는 null일 수 없습니다.")
    private Long hobbyId;

}
