package com.example.orbe.domain.hobby.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryHobbyListResponse {
    private final List<HobbyResponse> hobbyResponseList;

    @Getter
    @Builder
    public static class HobbyResponse {

        private Long hobbyId;
        private String title;
        private int maxPeople;
        private int currentPeople;
    }
}
