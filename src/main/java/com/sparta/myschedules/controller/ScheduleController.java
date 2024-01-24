package com.sparta.myschedules.controller;

import com.sparta.myschedules.dto.ScheduleRequestDto;
import com.sparta.myschedules.dto.ScheduleResponseDto;
import com.sparta.myschedules.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@AllArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping()
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping()
    public List<ScheduleResponseDto> getSchedules(){
        return scheduleService.getSchedules();
    }

    @GetMapping("/{id}")
    public ScheduleResponseDto getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id);
    }

    @PutMapping("/{id}/{password}")
    public Long updateSchedule(@PathVariable Long id, @PathVariable String password, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id, password, requestDto);
    }

    @DeleteMapping("/{id}/{password}")
    public Long deleteSchedule(@PathVariable Long id, @PathVariable String password) {
        return scheduleService.deleteSchedule(id, password);
    }
}