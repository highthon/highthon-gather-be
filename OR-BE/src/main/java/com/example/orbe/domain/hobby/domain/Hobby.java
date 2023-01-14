package com.example.orbe.domain.hobby.domain;

import com.example.orbe.domain.hobby.domain.enums.HobbyType;
import com.example.orbe.domain.todo.entity.Todo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Hobby {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hoby_id")
    private Long id;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String hobbyType;

    @Column(columnDefinition = "TINYINT(30)")
    private int maxPeople;

    @OneToMany(mappedBy = "hobby")
    private List<Todo> todoList = new ArrayList<>();

    @OneToMany(mappedBy = "hobby")
    private List<UserHobby> userHobbyList = new ArrayList<>();

    @Builder
    public Hobby(String title, String hobbyType, int maxPeople) {
        this.title = title;
        this.hobbyType = hobbyType;
        this.maxPeople = maxPeople;
    }


}
