package com.sparta.myschedules.entity;

import com.sparta.myschedules.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "content", nullable = false, length = 2048)
    private String content;

    @Column(name = "username", nullable = false, length = 32)
    private String username;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    public Schedule(ScheduleRequestDto requestDto) {
        this.name = requestDto.getName();
        this.content = requestDto.getContent();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.name = requestDto.getName();
        this.content = requestDto.getContent();
        this.username = requestDto.getUsername();
    }
}