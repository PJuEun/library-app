package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.AddRequest;
import com.group.libraryapp.dto.calculator.MinusRequest;
import com.group.libraryapp.dto.calculator.MultiplyRequest;
import org.springframework.web.bind.annotation.*;

// @ 문법 : 자바의 어노테이션
// 어노테이션 - 마법같은 일을 해준다고,,
@RestController // 이 클래스를 API의 진입 지점으로 만들어준다.
public class CalculatorController {

    /*
    덧셈 기능 (API)를 만들건데
    API 명세를 정해야 한다!

    - HTTP Method : GET (덧셈 결과를 달라)
    - HTTP Path : /add
    - 쿼리 : 2개 숫자 number1, number2
    - 결과 : 덧셈 결과
    */

    // GetMapping은 아래 함수를 GET API로 만듭니다.
    // 그런데 path를 /add로 설정합니다.
    // @RequestParam : 파라미터 이름과 같은 쿼리를 찾아 넣어준다. (이름이 동일해야함!)
    @GetMapping("/add")
    public int addTwoNumbers(@RequestParam int number1, @RequestParam int number2) { //@RequestParam은 파라미터 이름과 같은 쿼리를 찾아 넣어준다.
        return number1 + number2;
    }

    /*@PostMapping("/add")
    public int addTwoNumbers(@RequestBody AddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }*/

    /*
    뺄셈 기능 (API)를 만들건데
    API 명세를 정해야 한다!

    - HTTP Method : GET
    - HTTP Path : /minus
    - Query : num1 / num2 둘 다 실수 (int가 아니라 double)
    - 응답 : num1에서 num2를 뺀 값
    */
    @GetMapping("/minus")
    public double minusTwoNumbers(@RequestParam double num1, @RequestParam double num2) {
        return num1 - num2;
    }

    /*@PostMapping("/minus")
    public double minusTwoNumbers(@RequestBody MinusRequest request) {
        return request.getNum1() - request.getNum2();
    }*/

    // 곱셈 기능을 GET API로 만들었을 때,
    /* @GetMapping("/multiply")
    public int multiplyTwoNumbers(@RequestParam int num1, @RequestParam int num2) { return num1 * num2; } */

    /*
    - HTTP Method : POST (곱셈 결과를 달라)
    - HTTP Path : /multiply
    - 쿼리 : 2개 숫자 number1, number2
    - 결과 : 곱셈 결과 */

    // 이 어노테이션은 아래 함수를 POST method를 받게 해줌
    // POST 같은 경우는 "클래스"로 데이터를 받아야 한다 (Body를 쓰니까)
    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody MultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }
}
