package com.sparta.myschedules.service;

import com.sparta.myschedules.dto.ScheduleRequestDto;
import com.sparta.myschedules.dto.ScheduleResponseDto;
import com.sparta.myschedules.entity.Schedule;
import com.sparta.myschedules.repository.ScheduleRepository;
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
        return scheduleRepository.findAllBy().stream().map(ScheduleResponseDto::new).toList();
    }
}
