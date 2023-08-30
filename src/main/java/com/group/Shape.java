package com.group;

import com.group.libraryapp.Circle;
import com.group.libraryapp.Rectangle;
import com.group.libraryapp.ShapeDto;
import com.group.libraryapp.Square;

import java.util.List;

// 상속, 원래 있던 클래스의 기능을 확장해서 재정의하는 것
// 상속받아서 - 하위 클래스의 인스턴스를 만들 때 상위 타입으로 사용 가능함
// 재정의하지 않은 기능이 쓰이면 상위 기능을 자동으로 활용!

// abstract class 라는게 있는데, 추상 클래스를 사용하면
// 내가 함수를 만들지 않아도 된다.
// ※ 추상 클래스는 인스턴스화가 안됨!!!
// ※ 상속은 하나의 클래스만 가능!!
// --> 두 개 이상을 상속받기 위해서는 interface를 사용해야함!
// extends는 상속 = 클래스에서만 사용 가능
// interface는? implements

// 클래스 상속, 추상클래스, 인터페이스, extends / implements -> 새로운 클래스를 만들어야했음
// 잠깐 쓰고 버릴건데,, 클래스까지 만들기는 좀 그렇다!
// --> "익명클래스"

public abstract class Shape { // 추상클래스
    /* // Main.java에서 상속 관련 얘기할때,
    public int a() {
        return 10;
    }

    public double calculateRound() {
        return 0.0;
    }*/

    abstract public ShapeDto toDto(); // 추상메서드

//    public static Shape of(String str, List<Double> numbers) {
//        if(str.equals("RECTANGLE")) {
//            return new Rectangle(numbers);
//        } else if (str.equals("SQUARE")) {
//            return new Square(numbers);
//        } else {
//            return new Circle(numbers);
//        }
//    }

}
