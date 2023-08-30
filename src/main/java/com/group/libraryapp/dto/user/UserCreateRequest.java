package com.group.libraryapp.dto.user;

public class UserCreateRequest {
    private String name;
    // int는 null이 들어갈 수 없음
    // Integer는 null이 들어갈 수 있음
    // null = 값이 없음
    private Integer age;

    public UserCreateRequest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
