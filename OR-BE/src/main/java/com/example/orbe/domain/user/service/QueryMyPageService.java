package com.example.orbe.domain.user.service;

import com.example.orbe.domain.hobby.domain.repository.UserHobbyRepository;
import com.example.orbe.domain.user.domain.User;
import com.example.orbe.domain.user.facade.UserFacade;
import com.example.orbe.domain.user.presentation.dto.QueryMyPageResponse;
import com.example.orbe.domain.user.presentation.dto.QueryMyPageResponse.UserHobbies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryMyPageService {
    private final UserFacade userFacade;
    private final UserHobbyRepository userHobbyRepository;

    @Transactional(readOnly = true)
    public QueryMyPageResponse execute() {
        User user = userFacade.getCurrentUser();

        List<UserHobbies> userHobbies = userHobbyRepository.findAllByUser(user).stream()
                .map(
                        h ->
                                new UserHobbies(h.getHobby().getTitle(), h.getHobby().getId())
                ).toList();
        return QueryMyPageResponse.builder()
                .accountId(user.getAccountId())
                .name(user.getName())
                .hobbiesList(userHobbies)
                .build();
    }
}
