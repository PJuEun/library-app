package com.group.libraryapp.temp;

// Java에서 상속
// 내가 상속받고 있는 클래스 : 상위 클래스
// 상속하고 있는 나 : 하위 클래스
public class B extends A {

    // 오버라이드, 상위클래스에 있는 메소드를 내가 다시 정의하는 것
    @Override
    public void helloWorld() {
        super.helloWorld();
    }
}
