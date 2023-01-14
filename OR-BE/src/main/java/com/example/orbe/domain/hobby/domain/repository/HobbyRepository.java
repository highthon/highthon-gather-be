package com.example.orbe.domain.hobby.domain.repository;

import com.example.orbe.domain.hobby.domain.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
}
