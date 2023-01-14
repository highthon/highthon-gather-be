package com.example.orbe.domain.user.service;

import com.example.orbe.domain.user.domain.User;
import com.example.orbe.domain.user.domain.repository.UserRepository;
import com.example.orbe.domain.user.exception.UserAlreadyExistsException;
import com.example.orbe.domain.user.presentation.dto.SignUpRequest;
import com.example.orbe.domain.user.presentation.dto.TokenResponse;
import com.example.orbe.global.secruity.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(SignUpRequest request) {

        if(userRepository.existsByAccountId(request.getAccountId())) {
            throw UserAlreadyExistsException.EXCEPTION;
        }



        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .name(request.getName())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build()
        );



        String access = jwtTokenProvider.generateAccessToken(request.getAccountId());

        return TokenResponse.builder()
                .token(access)
                .expiredAt(jwtTokenProvider.getExpiredAt())
                .build();

    }
}
