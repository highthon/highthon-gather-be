package com.example.orbe.domain.user.presentation.dto;

import com.example.orbe.global.util.RegexProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    @NotEmpty(message = "account_id는 null이거나 공백일 수 없습니다.")
    private String accountId;
    @NotEmpty(message = "name는 null이거나 공백일 수 없습니다.")
    private String name;

    @Pattern(regexp = RegexProperty.PASSWORD)
    @NotEmpty(message = "password는 null이거나 공백일 수 없습니다.")
    private String password;
}
