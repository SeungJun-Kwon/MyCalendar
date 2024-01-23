# MySchedules
스파르타 코딩클럽 Spring 개인 과제

---

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

---

### Use Case Diagram

<image src = 'https://github.com/SeungJun-Kwon/MySchedules/assets/80217301/4f81f241-72c8-428e-9850-e29b55400acd' width = 600>

---

### API 테이블

|기능|Method|URL|Return|
|------|---|---|---|
|일정 조회하기|GET|/api/schedules|List<ScheduleResponseDto>|
|일정 선택해서 조회하기|GET|/api/schedules/{id}|ScheduleResponseDto|
|일정 생성하기|POST|/api/schedules|ScheduleResponseDto|
|일정 변경하기|PUT|/api/schedules/{id}|Long|
|일정 삭제하기|DELETE|/api/schedules/{id}|Long|

**조회 Response**

```
[
    {
        "id": 5,
        "name": "일정이다",
        "content": "일정일정",
        "username": "일정",
        "createdAt": "2024-01-23T16:15:14.421399",
        "modifiedAt": "2024-01-23T16:15:14.421399"
    },
    {
        "id": 1,
        "name": "24년 1월 23일",
        "content": "밥먹기 밥밥밥",
        "username": "권승준",
        "createdAt": "2024-01-22T21:18:00.890175",
        "modifiedAt": "2024-01-23T19:44:07.523576"
    }
]
```

**선택 조회 Request**

```
파라미터  
{id, Long, 일정 id}
```

**선택 조회 Response**

```
{
    "id": 1,
    "name": "24년 1월 23일",
    "content": "밥먹기 밥밥밥",
    "username": "권승준",
    "createdAt": "2024-01-22T21:18:00.890175",
    "modifiedAt": "2024-01-23T19:44:07.523576"
}
```

**생성 Request**

```
파라미터  
{name, String, 일정 이름}  
{content, String, 일정 내용}  
{username, String, 담당자 이름}  
{password, String, 비밀번호}

{
    "name": "name",
    "content": "content",
    "username": "username",
    "password": "password"
}
```

**생성 Response**

```
{
    "id": 9,
    "name": "name",
    "content": "content",
    "username": "username",
    "createdAt": "2024-01-23T20:25:05.6667431",
    "modifiedAt": "2024-01-23T20:25:05.6667431"
}
```

**변경 Request**

```
파라미터  
{name, String, 일정 이름}  
{content, String, 일정 내용}  
{username, String, 담당자 이름}

{
    "name":"name 수정",
    "content":"content 수정",
    "username":"username"
}
```

**변경 Response**

```
9
```

**삭제 Response**

```
9
```

---

### SQL

```
DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
	`id` bigint	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`content` varchar(2048) NOT NULL,
	`username` varchar(32) NOT NULL,
	`password` varchar(16) NOT NULL,
	'created_at' datetime(6) NOT NULL,
	'modified_at' datetime(6) NOT NULL
);
```

### 구현 화면

**전체 조회**
![image](https://github.com/SeungJun-Kwon/MySchedules/assets/80217301/09720c95-1921-414c-b8fa-497a41e329b6)

**등록**
![image](https://github.com/SeungJun-Kwon/MySchedules/assets/80217301/1fe7f977-d05c-4240-9b71-3ac830cf0cb5)

**선택 조회**
![image](https://github.com/SeungJun-Kwon/MySchedules/assets/80217301/5f3a0f4e-0bee-4a52-9ea3-7da4a823dd44)

**수정**
![image](https://github.com/SeungJun-Kwon/MySchedules/assets/80217301/e30dc9b0-3636-453c-85ce-9f0b3e7f6c8f)

**삭제**
![image](https://github.com/SeungJun-Kwon/MySchedules/assets/80217301/4a163237-f496-48b9-8f94-6cb8fc2dd647)
