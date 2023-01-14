package com.example.orbe.domain.hobby.facade;

import com.example.orbe.domain.hobby.domain.Hobby;
import com.example.orbe.domain.hobby.domain.repository.HobbyRepository;
import com.example.orbe.domain.hobby.domain.repository.UserHobbyRepository;
import com.example.orbe.domain.hobby.exceptoin.HobbyNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HobbyFacade {
    private final HobbyRepository hobbyRepository;
    private final UserHobbyRepository userHobbyRepository;

    public Hobby findById(Long id) {
        return hobbyRepository.findById(id)
                .orElseThrow(() -> HobbyNotFoundException.EXCEPTION);
    }

    public int getCurrentPeopleCount(Hobby hobby) {

        return userHobbyRepository.findAllByHobby(hobby).size();
    }
}
