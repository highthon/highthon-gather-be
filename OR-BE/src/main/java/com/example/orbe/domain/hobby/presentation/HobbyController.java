package com.example.orbe.domain.hobby.presentation;

import com.example.orbe.domain.hobby.presentation.dto.CreateHobbyRequest;
import com.example.orbe.domain.hobby.presentation.dto.QueryHobbyInfoResponse;
import com.example.orbe.domain.hobby.presentation.dto.QueryHobbyListResponse;
import com.example.orbe.domain.hobby.service.CreateHobbyService;
import com.example.orbe.domain.hobby.service.JoinHobbyService;
import com.example.orbe.domain.hobby.service.QueryHobbyInfoService;
import com.example.orbe.domain.hobby.service.QueryHobbyListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hobbies")
@RequiredArgsConstructor
public class HobbyController {
    private final CreateHobbyService createHobbyService;
    private final JoinHobbyService joinHobbyService;
    private final QueryHobbyListService queryHobbyListService;
    private final QueryHobbyInfoService queryHobbyInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createHobby(@RequestBody @Valid CreateHobbyRequest request) {
        createHobbyService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{hobby-id}")
    public void joinHobby(@PathVariable("hobby-id") Long hobbyId) {
        joinHobbyService.execute(hobbyId);
    }

    @GetMapping
    public QueryHobbyListResponse queryHobbyList() {
        return queryHobbyListService.execute();
    }

    @GetMapping("/{hobby-id}")
    public QueryHobbyInfoResponse queryHobbyInfo(@PathVariable("hobby-id") Long hobbyId) {
        return queryHobbyInfoService.execute(hobbyId);
    }
}
