package com.example.orbe.domain.todo.entity.repository;

import com.example.orbe.domain.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
