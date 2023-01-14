package com.example.orbe.domain.user.service;

import com.example.orbe.domain.user.domain.User;
import com.example.orbe.domain.user.domain.repository.UserRepository;
import com.example.orbe.domain.user.exception.WrongPasswordException;
import com.example.orbe.domain.user.facade.UserFacade;
import com.example.orbe.domain.user.presentation.dto.LoginRequest;
import com.example.orbe.domain.user.presentation.dto.TokenResponse;
import com.example.orbe.global.secruity.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public TokenResponse execute(LoginRequest request) {
        User user = userFacade.getUserByAccountId(request.getAccountId());

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw WrongPasswordException.EXCEPTION;
        }

        String access = jwtTokenProvider.generateAccessToken(user.getAccountId());

        return TokenResponse.builder()
                .token(access)
                .expiredAt(jwtTokenProvider.getExpiredAt())
                .build();
    }
}
