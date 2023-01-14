package com.example.orbe.domain.todo.entity;

import com.example.orbe.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(CompletedTodoId.class)
public class CompletedTodo {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="todo_id", nullable = false)
    private Todo todo;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Long hobbyId;
}
