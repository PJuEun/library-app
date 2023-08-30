package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.UserCreateRequest;
import com.group.libraryapp.dto.user.UserResponse;
import com.group.libraryapp.service.user.UserService;
import com.group.libraryapp.dto.user.UserUpdateRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController // 어노테이션 = 마법 1) 이 클래스를 APi 진입 지점 / 2) "스프링 빈"으로 등록
// 서버가 시작되면, 스프링 서버 내부에 거대한 컨테이너를 만들게 된다!
// 컨테이너 안에는 클래스가 들어가게 된다! 이때 다양한 정보도 함께 들어있고 인스턴스화도 이루어진다

public class UserController { // API 관련

    private final UserService userService;

    // 객체에 있는 static이 아닌 함수를 실행하려면 가장 먼저 무엇을 해야했죠?
    // 인스턴스화 new Person(); person.함수호출()
    // 어 이상하다?! 우리 분명... new UserController()를 한 적이 없는데..
    // JdbcTemplate 매개변수를 준 적도 없어...
    // 이게 도대체 무슨 일이란 말인가...

    // 의아한 코드!
    // [1] 우리가 어떤 클래스의 함수를 사용하려면 무엇을 해야하죠?
    //      인스턴스화를 해야 한다! (변수로 갖고 있어야 함수를 쓰겠지~)
    //      우리는 UserController의 함수를 씀.. 인스턴스화 X
    //      new UserController(); 을 작성한 적이 없음
    // [2] JdbcTemplate도 변수로 만든 적이 없어 (인스턴스화 한 적이 없어)

    // 객체 - 그냥 사물 (ex. 사람)
    // 클래스 - 객체를 코드로 옮긴거
    // 인스턴스 - 클래스를 변수로 옮긴 것 (new 클래스이름) --> 클래스의 생성자

    // jdbcTemplate은 그냥 가져다가 쓰고있죠! 우리가 직접 new jdbcTemplate을 안했죠!
    // UserService는 직접 new를 하고있다!
    // 질문 : UserService도 new를 하지 않고, jdbcTemplate처럼 그냥 가져다 쓸 수 있을까요?
    // 그 이유는 UserService가 "스프링 빈"이 아니기 때문!!
    // UserService를 스프링 빈으로 만들면 바로 가져다 쓸 수 있겠네요?!
    public UserController(UserService userService) { // 생성자, new UserController();
        this.userService = userService;
    }

    // 무려 3가지 일을 하고 있다. (3단 분리)
    // [1] HTTP, API와 관련된 일 - PUT /user, Body를 객체로 변환 -> Controller
    // [2] 예외를 처리하고 있어요. (비즈니스상 일어날 수 없는 일) -> Service
    // [3] 실제 DB와 통신해서 SQL을 사용. -> Repository

    // 1번째 -  왜 우리 코드가 쉽지 않은 코드인가?
    //         자그마치 3가지 일을 함께 하고 있었기 때문 - API관련 / 흐름제어관련 / DB관련
    // 2번째 - UserController -> UserController + UserService + UserRepository로 쪼갰음!
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    // 어떤 주어진 이름으로 유저가 없으면 에러를! 있으면 삭제를!
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }
    
//    private final JdbcTemplate jdbcTemplate;
//
//    public UserController(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
////    private List<User> users = new ArrayList<>();
//
//    // 실제 유저를 "저장"
//    // 우선은 간단하게... 일요일(7/9)에 자동차 저장 어떻게 했죠?
//    // 그냥 List<Car> 만들어서 저장했죠~
//    // List<User> 만들어서 저장~
//    @PostMapping("/user") // 유저를 저장하는 API
//    public void saveUser(@RequestBody UserCreateRequest request) {
//        String  sql = "INSERT INTO user (name, age) VALUES (?, ?)";
//        String name = request.getName();
//        Integer age = request.getAge();
//        jdbcTemplate.update(sql, name, age); // name, age는 (?, ?)에 넣을 것임
//        // 위의 3줄과 아래 1줄은 동일하다.
//        // -> jdbcTemplate.update(sql, request.getName(), request.getAge());
//
////        User newUser = new User(request.getName(), request.getAge());
////        users.add(newUser);
//
//
//    }
//
//    // 목표 : User 객체를 UserResponse 객체로 바꿔서 반환
//    // 문제는 User가 List에 들어 있음 -> List<User>를 List<UserResponse>로 변경
//    @GetMapping("/user") // 유저를 반환하는 API
//    public List<UserResponse> getUsers() {
//        // 하고싶은건, 데이터베이스 user 테이블에 저장되어 있는 데이터를 가져와서 --> sql
//        // 이 API에 맞게 List<UserResponse>를 반환하는 것!
//        String sql = "SELECT * FROM user";
//        // 우리가 쓰고싶은 함수는 jdbcTemplate.query(문자열, RowMapper)
//        // RowMapper를 찾아보니까 인터페이스임
//        // 1회성으로 인터페이스를 집어 넣어야 하는 상황 --> 익명 클래스
//        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() { // query : 데이터를 가져오는것
//            // new RowMapper<UserResponse>()
//            // RowMapper를 사용해서 데이터베이스의 검색 결과를 UserResponse로 변경하겠다!
//            // 만약 검색결과를 정수로 가져오겠다면 new RowMapper<Integer>
//            @Override
//            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
//                long id = rs.getLong("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                return new UserResponse(id, name, age);
//            }
//        });
//
//
//        // 아래줄을 Python 으로 표현하자면, responses = []
////        List<UserResponse> responses = new ArrayList<>();
//
//        // Java식, responses.get(숫자) | Python식, responses[숫자]
//
//        // 어머 비어있는 리스트가 만들어졌네~
//        // User 객체를 UserResponse 객체로 "바꿔서" "하나씩" 집어넣는다.
//        // '반복문' --> for문 --> 시작을 어디서 할거냐~ 어디까지 할거냐~ 그 다음 바뀌는게 뭐냐
////        for (int i = 0; i < users.size(); i++) {
//            /*
//            User user = users.get(i); // User를 UserResponse로 바꿀건데 일단 가져옴
//            // ㄹㅇ 바꿈
//            UserResponse res = new UserResponse(i+1, user.getName(), user.getAge());
//            // "집어 넣는다"
//            responses.add(res);
//            */
//
//            // 위의 3줄을 한줄로 간단히 작성하면,
////            responses.add(new UserResponse(i+1, users.get(i).getName(), users.get(i).getAge()));
//            // --> UserResponse의 생성자에서 name, age를 미리 각각 가져올 수 있게 수정해주면 아래와 같이 사용 가능
//            // responses.add(new UserResponse(i+1, users.get(i)));
////        }
////        return responses;
//        /*
//        // Stream 함수형 프로그래밍 기법 지원 Java8 (대혁신)
//        // Java7 쓰면 가급적 빠르게 이직을..
//        int i = 0;
//        return users.stream().map(user -> new UserResponse(i+1, user)).collect(Collectors.toList());
//        */
//    }
//
//    // 이번시간(7/14) 목표 : 2가지 기능 더 만들기
//    // 유저 정보 수정, 유저를 삭제
//    // API를 2개 더 만든다~~
//
//    // PUT /user => 유저 수정 기능
//    // 질문) 해당 id를 가진 유저가 있는지 없는지 어떻게 알 수 있을까?
//    // DB를 확인한다! -> DB 조회 -> SELECT SQL을 사용해서 조회
//    @PutMapping("/user")
//    public void updateUser(@RequestBody UserUpdateRequest request) {
//        String readSql = "SELECT * FROM user WHERE id = ?";
//        /*List<UserResponse> users = jdbcTemplate.query(readSql, new RowMapper<UserResponse>() {
//            @Override
//            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
//                long id = rs.getLong("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                return new UserResponse(id, name, age);
//            }
//        }, request.getId());
//        if (users.isEmpty()) {
//            throw new IllegalArgumentException();
//        }*/
//
//        // 위의 주석처리 코드를 축약해서 아래 4줄로 만들 수 있음!
//        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
//        if (isUserNotExist) {
//            throw new IllegalArgumentException();
//        }
//
//        String sql = "UPDATE user SET name = ? WHERE id = ?";
//        jdbcTemplate.update(sql, request.getName(), request.getId());
//    }
//
//    // DELETE /user => 유저 삭제 기능
//    // 존재하지 않는 유저에 대해서는 200(성공)을 주면 안될 것 같아.. (=스펙의 일부)
//    // 어떻게 하면 200말고 다른 응답 상태를 줄 수 있을까? -> 예외 (RuntimeException)
//    // 너가 준 정보는 찾을 수 없어 = 404
//    // 여기도 수정하는 기능이랑 유사하게 DB를 확인해서 유저가 없으면 예외를 던지게 만들어 보자!
//    @DeleteMapping("/user") // 유저 삭제 기능
//    public void deleteUser(@RequestParam String name) {
//        String readSql = "SELECT * FROM user WHERE name = ?";
//        /*List<UserResponse> users = jdbcTemplate.query(readSql, new RowMapper<UserResponse>() {
//            @Override
//            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
//                long id = rs.getLong("id");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                return new UserResponse(id, name, age);
//            }
//        }, name);
//        if (users.isEmpty()) {
//            throw new IllegalArgumentException();
//        }*/
//
//        // 위의 주석처리 코드를 축약해서 아래 4줄로 만들 수 있음!
//        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
//        if (isUserNotExist) {
//            throw new IllegalArgumentException();
//        }
//
//
//        String sql = "DELETE FROM user WHERE name = ?";
//        jdbcTemplate.update(sql, name);
//    }




}

