package com.group.libraryapp.controller.Fruit;

import com.group.libraryapp.dto.fruit.FruitCreateRequest;
import com.group.libraryapp.service.fruit.FruitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
- 과일 가게 사장님을 위해 "과일 정보를 등록할 수 있는 기능"을 만들어주세요.
-> Table 만들어야겠다. / POST /fruit + Controller Service Repository
- 과일 정보는 이름, 가격, 유통기한이 있습니다.

*/
@RestController
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        fruitService.saveFruit(request);
    }

}
