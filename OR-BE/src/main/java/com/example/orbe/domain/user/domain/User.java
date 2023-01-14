package com.example.orbe.domain.user.domain;

import com.example.orbe.domain.user.domain.enums.Authority;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String accountId;
    @Column(columnDefinition = "VARCHAR(5)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    private String password;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String profileUrl;


    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String accountId, String name, String password, String profileUrl) {
        this.accountId = accountId;
        this.name = name;
        this.password = password;
        this.profileUrl = profileUrl;
        this.authority = Authority.USER;
    }
}
