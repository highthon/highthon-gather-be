package com.example.orbe.domain.user.presentation;

import com.example.orbe.domain.user.presentation.dto.LoginRequest;
import com.example.orbe.domain.user.presentation.dto.QueryMyPageResponse;
import com.example.orbe.domain.user.presentation.dto.SignUpRequest;
import com.example.orbe.domain.user.presentation.dto.TokenResponse;
import com.example.orbe.domain.user.service.LoginService;
import com.example.orbe.domain.user.service.QueryMyPageService;
import com.example.orbe.domain.user.service.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final SignUpService signUpService;
    private final LoginService loginService;
    private final QueryMyPageService queryMyPageService;

    @PostMapping("/signup")
    public TokenResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return signUpService.execute(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }

    @GetMapping("/my")
    public QueryMyPageResponse myPage() {
        return queryMyPageService.execute();
    }
}
