package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.UserCreateRequest;
import com.group.libraryapp.dto.user.UserResponse;
import com.group.libraryapp.dto.user.UserUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService { // 흐름제어관련

    /* // JAP 사용하기 전
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public void updateUser(UserUpdateRequest request) {
//        List<Integer> users = userRepository.findUser(request.getId());
//        if (users.isEmpty()) {
//            throw new IllegalArgumentException("해당 id를 가진 유저가 없습니다");
//        }
//        userRepository.updateUser(request.getName(), request.getId());
//    }

    public List<UserResponse> getUsers() {
        return userRepository.getUsers();
    }*/

    // JAP 사용하기 후
    /*
    * 객체 : @Entity
    * save(객체) : 저장하는 기능
    * findAll() : DB에서 모든 객체를 가져온다.
    * findById(id) :특정 id로 객체를 가져온다.
    * */
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 트랜잭션 적용 끝!
    @Transactional
    public void saveUser(UserCreateRequest request) {
        User user = new User(request.getName(), request.getAge());
        userRepository.save(user);
    }

    // select * from user;
    @Transactional
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<>();

        for (User user : users) {
            UserResponse response = new UserResponse(user);
            responses.add(response);
        }
        return responses;

        // ↓ 코드를 더 간결하게 만들 수 있음
//        return userRepository.findAll().stream()
//                .map(UserResponse::new)
//                .collect(Collectors.toList());
    }

    // SELECT를 써서 해당 id를 가진 유저가 있는지 확인 - 없으면 에러
    // UPDATE를 써서 실제 업데이트
    @Transactional
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow();
        user.updateName(request.getName());
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            throw new IllegalArgumentException();
        }
        userRepository.delete(user); // 알아서 userRepository가 이 user를 제거해줌
    }
}
