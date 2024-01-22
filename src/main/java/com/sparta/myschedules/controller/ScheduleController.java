package com.sparta.myschedules.controller;

import com.sparta.myschedules.dto.ScheduleRequestDto;
import com.sparta.myschedules.dto.ScheduleResponseDto;
import com.sparta.myschedules.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping()
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping()
    public List<ScheduleResponseDto> getSchedules(){
        return scheduleService.getSchedules();
    }
}
