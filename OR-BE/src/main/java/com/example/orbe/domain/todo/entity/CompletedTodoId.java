package com.example.orbe.domain.todo.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class CompletedTodoId implements Serializable {
    private Long todo;
    private Long user;
}
