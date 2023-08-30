package com.group.libraryapp.domain.user;

import javax.persistence.*;

// 아니~~ SQL을 안쓴다는게 무슨 말이여?

// 여기에 이제 JPA를 적용할겁니다!
// 이 객체랑 우리가 만들었던 user 테이블이랑 "매핑"을 할거에요!
// 참고) Entity 단어의 뜻 : 저장되고 관리되어야 하는 데이터
@Entity // 마법 - 이 객체는 JPA를 적용한 객체야~
public class User {

    @Id // primary key(엑셀에 가장 왼쪽에 있는 자동 생성숫자처럼 데이터가 갖는 고유한 값) 라는 뜻!
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue : 이 값은 자동생성 / (strategy = GenerationType.IDENTITY) : auto_increment
    private Long id = null; // int, long / Integer, Long : 0으로 구분이 애매할 수 있으니 아예 확실히 null을 쓰는 경우가 꽤 많음

    @Column(length = 20) // 없어도 동작하는데는 문제없음
    private String name;
    private Integer age;

    // JPA는 적용하려면 @Entity 클래스에 매개변수가 없는 "기본 생성자"가 필수
    public User() {

    }

    public User(String name, Integer age) {
        if (name.isEmpty()) { //isBlank
            throw new RuntimeException("사람의 이름이 비어있습니다.");
        }
        this.name = name;
        this.age = age;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() { return id; }
}
