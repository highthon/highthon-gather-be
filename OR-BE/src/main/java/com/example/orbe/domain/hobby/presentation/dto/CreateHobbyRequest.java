package com.example.orbe.domain.hobby.presentation.dto;

import com.example.orbe.domain.hobby.domain.enums.HobbyType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CreateHobbyRequest {

    @NotNull(message = "title은 null일 수 없습니다.")
    private String title;

    @NotNull(message = "hobby_type는 null일 수 없습니다.")
    private List<HobbyType> hobbyType;

    @NotNull(message = "max_people은 null일 수 없습니다.")
    private int maxPeople;
}
