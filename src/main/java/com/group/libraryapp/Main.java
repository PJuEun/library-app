package com.group.libraryapp;

import com.group.Shape;

import java.util.Arrays;
import java.util.List;

// 지난시간(~0711)까지 GET API, POST API도 만들어봤음!!
// 2가지 기능 - 유저를 저장하는 기능, 유저를 가져오는 기능.
// 오늘은... Java 문법을 더 알아야 하는 것들이 있다!
public class Main {
    // static이 무엇일까?
    // static이 있는 것 / 없는 것
    public static void main(String[] args) {
        /* // 상속 관련
        Shape shape = new Shape();
        System.out.println(shape.a()); // 10
        System.out.println(shape.calculateRound()); // 0.0

        // 자바의 변수 선언방법
        // [타입] [변수이름] = 값;
        // [타입] [변수이름] = new 생성자호출;
        Shape rectangle = new Rectangle();
        System.out.println(rectangle.calculateRound()); // 3.0
        System.out.println(rectangle.a()); // 10
        */

        /*
        // 어떻게 함수를 바로 부름?
        // 원래 함수를 호출하려면
        // new 연산자를 써서 인스턴스를 만들어서 호출
        ShapeDto.getNum2();

        ShapeDto shape = new ShapeDto();
        shape.getNum();

        // main2 함수를 호출하는 방법!
        // 1) static 사용 => public static void main2()
        // 2) main2를 인스턴스화 => Main m = new Main(); m.main2();
        */

        /* // 1번.
        ShapeDto dto = calculate("RECTANGLE", Arrays.asList(1.0, 2.0));
        System.out.println(dto.getName());
        System.out.println(dto.getRound());*/
    }

    // 그럼 1번이 좋은 방법일까?
    // C언어에서는 이렇게만 해야한다 -> Class가 없으니까
    // 단점 1) 만약에 도형의 개수가 늘어나면?
    // 단점 2) 만약에 둘레뿐 아니라 넓이도 구한다면? 혹은 다른 무언가도 구해야한다면?


    public static ShapeDto calculate(String str, List<Double> numbers) {

        /* // 1번.
        if(str.equals("RECTANGLE")) {
            double round = (numbers.get(0) + numbers.get(1)) * 2;
            return new ShapeDto("직사각형", round);
        }

        if(str.equals("SQUARE")) {
            double round = numbers.get(0) * 4;
            return new ShapeDto("정사각형", round);
        }

        if(str.equals("CIRCLE")) {
            double round = numbers.get(0) * 2 * Math.PI;
            return new ShapeDto("원", round);
        }

        throw new RuntimeException("약속되지 않은 도형이다.");*/

        // else를 안쓰고 else if로 끝낸다면 Shape shape = null; 해줘야함
        // 변수에 null을 최대한 넣지 않는게 좋음!
        Shape shape;
        if(str.equals("RECTANGLE")) {
            shape = new Rectangle(numbers);
        } else if (str.equals("SQUARE")) {
            shape = new Square(numbers);
        } else {
            shape = new Circle(numbers);
        }

        // Shape.java에 of를 사용하게 된다면,
        // Shape shape = Shape.of(str, numbers);

        // Enum Class 라는 것을 쓰면 됨~
        return shape.toDto();
    }
}
