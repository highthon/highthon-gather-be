package com.example.orbe.domain.user.presentation.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @NotEmpty(message = "account_id는 null이거나 공백일 수 없습니다.")
    private String accountId;

    @NotEmpty(message = "password는 null이거나 공백일 수 없습니다.")
    private String password;
}
