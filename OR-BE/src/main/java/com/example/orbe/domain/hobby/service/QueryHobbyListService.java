package com.example.orbe.domain.hobby.service;

import com.example.orbe.domain.hobby.domain.repository.HobbyRepository;
import com.example.orbe.domain.hobby.facade.HobbyFacade;
import com.example.orbe.domain.hobby.presentation.dto.QueryHobbyListResponse;
import com.example.orbe.domain.hobby.presentation.dto.QueryHobbyListResponse.HobbyResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryHobbyListService {
    private final HobbyRepository hobbyRepository;
    private final HobbyFacade hobbyFacade;

    @Transactional(readOnly = true)
    public QueryHobbyListResponse execute() {
        List<HobbyResponse> hobbyResponseList = hobbyRepository.findAll().stream()
                .map(
                        h -> HobbyResponse.builder()
                                .hobbyId(h.getId())
                                .title(h.getTitle())
                                .currentPeople(hobbyFacade.getCurrentPeopleCount(h))
                                .maxPeople(h.getMaxPeople())
                                .build()
                ).toList();
        return new QueryHobbyListResponse(hobbyResponseList);
    }
}
