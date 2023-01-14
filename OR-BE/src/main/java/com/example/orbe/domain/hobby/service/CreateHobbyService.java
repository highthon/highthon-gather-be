package com.example.orbe.domain.hobby.service;

import com.example.orbe.domain.hobby.domain.Hobby;
import com.example.orbe.domain.hobby.domain.repository.HobbyRepository;
import com.example.orbe.domain.hobby.presentation.dto.CreateHobbyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateHobbyService {
    private final HobbyRepository hobbyRepository;

    @Transactional
    public void execute(CreateHobbyRequest request) {
        String hobbyType = request.getHobbyType().stream()
                        .map(Enum::toString)
                        .collect(Collectors.joining(","));

        hobbyRepository.save(
                Hobby.builder()
                        .title(request.getTitle())
                        .hobbyType(hobbyType)
                        .maxPeople(request.getMaxPeople())
                        .build()
        );
    }
}
