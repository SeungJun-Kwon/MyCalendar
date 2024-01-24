package com.sparta.myschedules.controller;

import com.sparta.myschedules.dto.ScheduleRequestDto;
import com.sparta.myschedules.dto.ScheduleResponseDto;
import com.sparta.myschedules.entity.ResponseMessage;
import com.sparta.myschedules.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseMessage<?>> getScheduleById(@PathVariable Long id) {
        ScheduleResponseDto dto;

        try {
            dto = scheduleService.getScheduleById(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().
                    body(ResponseMessage.builder()
                            .msg(id + " 유저 탐색 실패")
                            .httpCode(HttpStatus.BAD_REQUEST.value())
                            .data(null)
                            .build());
        }

        return ResponseEntity.ok(ResponseMessage.builder()
                .msg(id + " 유저 탐색 완료")
                .httpCode(HttpStatus.OK.value())
                .data(dto)
                .build());
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