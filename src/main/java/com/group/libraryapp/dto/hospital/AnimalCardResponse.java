package com.group.libraryapp.dto.hospital;

import com.group.libraryapp.domain.hospital.AnimalCard;

public class AnimalCardResponse {

    private Long id;
    private String name;
    private int age;
    private String type;
    private String symptom;

    public AnimalCardResponse(AnimalCard ac) {
        this.id = ac.getId();
        this.name = ac.getName();
        this.age = ac.getAge();
        this.type = ac.getType();
        this.symptom = ac.getSymptom();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public String getSymptom() {
        return symptom;
    }
}
