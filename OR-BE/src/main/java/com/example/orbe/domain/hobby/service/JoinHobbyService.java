package com.example.orbe.domain.hobby.service;

import com.example.orbe.domain.hobby.domain.Hobby;
import com.example.orbe.domain.hobby.domain.UserHobby;
import com.example.orbe.domain.hobby.domain.repository.UserHobbyRepository;
import com.example.orbe.domain.hobby.exceptoin.AlreadyJoinedException;
import com.example.orbe.domain.hobby.exceptoin.HobbyFullException;
import com.example.orbe.domain.hobby.facade.HobbyFacade;
import com.example.orbe.domain.user.domain.User;
import com.example.orbe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JoinHobbyService {
    private final UserHobbyRepository userHobbyRepository;
    private final HobbyFacade hobbyFacade;

    private final UserFacade userFacade;

    @Transactional
    public void execute(Long hobbyId) {
        Hobby hobby = hobbyFacade.findById(hobbyId);
        if(hobby.getMaxPeople() <= hobbyFacade.getCurrentPeopleCount(hobby)) {
            throw HobbyFullException.EXCEPTION;
        }

        User user = userFacade.getCurrentUser();
        if(!userHobbyRepository.existsByHobbyAndUser(hobby, user)) {
            throw AlreadyJoinedException.EXCEPTION;
        }

        userHobbyRepository.save(
                UserHobby.builder()
                        .hobby(hobby)
                        .user(user)
                        .build()
        );
    }
}
