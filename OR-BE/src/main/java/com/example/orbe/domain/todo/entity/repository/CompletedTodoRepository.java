package com.example.orbe.domain.todo.entity.repository;

import com.example.orbe.domain.hobby.domain.Hobby;
import com.example.orbe.domain.todo.entity.CompletedTodo;
import com.example.orbe.domain.todo.entity.CompletedTodoId;
import com.example.orbe.domain.todo.entity.Todo;
import com.example.orbe.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CompletedTodoRepository extends JpaRepository<CompletedTodo, CompletedTodoId> {
    boolean existsByUserAndTodo(User user, Todo todo);

    List<CompletedTodo> findAllByHobbyId(Long hobbyId);
}
