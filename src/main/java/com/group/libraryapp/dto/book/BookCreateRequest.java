package com.group.libraryapp.dto.book;

public class BookCreateRequest {
    private String name;

    /*
     * RequestBody에 사용할 JSON을 받는 DTO의 경우에 사실은 생성자가 필요하지 않음!
     * 지금 본 것처럼 필드가 하나 있는데 생성자가 있으면 오히려 에러가 남
     *
    public BookCreateRequest(Long id, String name) {
        this.name = name;
    } */

    public String getName() {
        return name;
    }
}
