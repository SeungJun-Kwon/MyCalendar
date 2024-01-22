# MyCalendar
스파르타 코딩클럽 Spring 개인 과제

### 스케줄 기능 설계

1. 접속 하자마자 일정 전체 목록 조회하기
   
        GET API 사용해서 일정 목록 불러오기

2. 일정 선택해서 조회하기

       GET API 사용해서 ID 값으로 일정 조회하기
   
3. 일정 생성하기
   
        POST API 사용해서 일정 신규 생성하기
        생성된 일정 반환
   
4. 일정 변경하기
   
        PUT API 사용해서 일정 내용 변경하기
        사용자가 클릭한 일정이 DB에 존재하는지 확인하기
        해당 일정 내용 변경
   
5. 일정 삭제하기
   
        DELETE API 사용해서 일정 삭제하기
        사용자가 삭제하려는 일정이 DB에 존재하는지 확인하기
        DB에서 해당 일정 삭제

### Use Case Diagram

<image src = 'https://github.com/SeungJun-Kwon/MyCalendar/assets/80217301/9661118b-341b-429b-bf1d-e08fe2d071e5' width = 600>

### API 테이블

|기능|Method|URL|Return|
|------|---|---|---|
|일정 생성하기|POST|/api/schedules|ScheduleResponseDto|
|일정 조회하기|GET|/api/schedules|List<ScheduleResponseDto>|
|일정 선택해서 조회하기|GET|/api/schedules/{id}|ScheduleResponseDto|
|일정 변경하기|PUT|/api/schedules/{id}|Long|
|일정 삭제하기|DELETE|/api/schedules/{id}|Long|
