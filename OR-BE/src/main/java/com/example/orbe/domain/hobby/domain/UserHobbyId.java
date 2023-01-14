package com.example.orbe.domain.hobby.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class UserHobbyId implements Serializable {
    private Long user;

    private Long hobby;
}
