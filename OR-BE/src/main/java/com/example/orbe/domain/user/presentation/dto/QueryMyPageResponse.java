package com.example.orbe.domain.user.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class QueryMyPageResponse {
    private final String userProfileImgUrl;
    private final String accountId;
    private final String name;

    private final List<UserHobbies> hobbiesList;

    @Getter
    @AllArgsConstructor
    public static class UserHobbies {
        private String name;
        private Long hobbyId;
    }
}
