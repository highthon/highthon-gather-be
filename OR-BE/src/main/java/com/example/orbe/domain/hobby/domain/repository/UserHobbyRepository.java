package com.example.orbe.domain.hobby.domain.repository;

import com.example.orbe.domain.hobby.domain.Hobby;
import com.example.orbe.domain.hobby.domain.UserHobby;
import com.example.orbe.domain.hobby.domain.UserHobbyId;
import com.example.orbe.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserHobbyRepository extends JpaRepository<UserHobby, UserHobbyId> {
    List<UserHobby> findAllByHobby(Hobby hobby);

    List<UserHobby> findAllByUser(User user);

    boolean existsByHobbyAndUser(Hobby hobby, User user);
}
