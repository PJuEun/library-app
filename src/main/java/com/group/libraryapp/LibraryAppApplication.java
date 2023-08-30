package com.group.libraryapp;
// 패키지 = 폴더

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Java의 문법
// "어노테이션", 주석 메모 @로 시작하는 것을 "어노테이션"
// 메모와 비슷한 역할!
// 어노테이션은 '메모'만 하는게 아니에요.
// 어노테이션 = 마법, (어노테이션 종류마다 마법의 종류가 다르다!)
// 서버를 만들기 위한 재료 "스프링",
// @SpringBootApplication <--- 이 재료를 다 준비해주는 마법
@SpringBootApplication
public class LibraryAppApplication {

  public static void main(String[] args) {
    /*
    // 자바에는 Map이란게 있다! (Collection의 일종, Collection = 데이터의 모음)
    int a = 3; // 데이터가 1개
    List<Integer> list = Arrays.asList(1, 2, 3); // 데이터가 3개, 데이터 모음
    Map<String, String> map = new HashMap<>();
    map.put("이름", "최태현");
    map.get("이름");
    // Python의 dict이다
    */

    SpringApplication.run(LibraryAppApplication.class, args);
  }

}
