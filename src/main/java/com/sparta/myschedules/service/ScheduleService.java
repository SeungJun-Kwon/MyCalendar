package com.sparta.myschedules.service;

import com.sparta.myschedules.dto.ScheduleRequestDto;
import com.sparta.myschedules.dto.ScheduleResponseDto;
import com.sparta.myschedules.entity.Schedule;
import com.sparta.myschedules.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);

        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saveSchedule);
    }

    public List<ScheduleResponseDto> getSchedules() {
        return scheduleRepository.findAllByOrderByCreatedAt().stream().map(ScheduleResponseDto::new).toList();
    }

    @Transactional
    public Long updateSchedule(Long id, String password, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 스케줄이 존재하지 않습니다.")
        );

        if(!schedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        schedule.update(requestDto);

        return id;
    };

    public Long deleteSchedule(Long id, String password) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow( () ->
                new IllegalArgumentException("선택한 스케줄이 존재하지 않습니다.")
        );

        if(!schedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        scheduleRepository.delete(schedule);

        return id;
    }
}
