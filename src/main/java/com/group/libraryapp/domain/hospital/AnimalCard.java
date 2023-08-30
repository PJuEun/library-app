package com.group.libraryapp.domain.hospital;

import javax.persistence.*;

/*
 * 우리가 만들려는 SW - 동물병원 키오스크
 * 접수 버튼 ->
 * "이름 / 동물 나이 / 동물 유형 / 증상" 입력
 * --> 접수가 완료
 * 동물병원 접수 테이블 + 객체 + Repository + Service + Controller (DTO)
 * 1. 접수하는 기능 -> POST
 * 2. 현재 접수 현황을 볼 수 있는 기능 -> GET
 * */

@Entity
public class AnimalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(length = 20)
    private String name;
    private int age;
    private String type;
    private String symptom;

    public AnimalCard() { }

    public AnimalCard(String name, int age, String type, String symptom) {
        // id는 자동 생성이라 굳이 필요없음!
        this.name = name;
        this.age = age;
        this.type = type;
        this.symptom = symptom;
    }

    public Long getId() { return id; }

    public String getName() {
        return name;
    }

    public int getAge() { return age; }

    public String getType() {
        return type;
    }

    public String getSymptom() {
        return symptom;
    }
}
