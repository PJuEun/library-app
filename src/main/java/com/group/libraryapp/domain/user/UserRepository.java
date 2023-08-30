package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA : 스프링과 JPA를 함께 쉽게 쓰게 도와주는 친구
// JPA : 원천기술
public interface UserRepository extends JpaRepository<User, Long> { // JpaRepository<객체이름, id타입>

    // 함수의 윗부분(시그니처)만 작성하면...
    // select * from user where name = ?;
    // 있으면 User 주고 없으면 null을 줌
    User findByName(String name); // public은 interface안에 있으면 생략 가능해서 생략함

    // Optional<User> findByName(String name);
    // Optional이 무엇인가?!
    // Java에서 가장 많이 개발자가 실수를 하는 부분 중 하나 -> null 관리
    // null이 될 수 있는 객체랑 null이 될 수 없는 객체를 분리하자
    // Optional이란걸 만들어서 Optional<User> -> 이 안에 User가 있는데 null일 수 있어!
    // Java 8버전부터 사용가능!
}
