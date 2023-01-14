package com.example.orbe.domain.user.presentation.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TokenResponse {
    private final String token;

    private final LocalDateTime expiredAt;
}
