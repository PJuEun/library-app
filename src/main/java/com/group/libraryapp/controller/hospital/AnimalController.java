package com.group.libraryapp.controller.hospital;

import com.group.libraryapp.dto.hospital.AnimalCardCreateRequest;
import com.group.libraryapp.dto.hospital.AnimalCardResponse;
import com.group.libraryapp.service.hospital.AnimalCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController {
    private final AnimalCardService animalCardService;

    public AnimalController(AnimalCardService animalCardService) { this.animalCardService = animalCardService; }

    @PostMapping("/animal-card")
    public void saveAnimal(@RequestBody AnimalCardCreateRequest request) {
        animalCardService.saveAnimal(request);
    }

    @GetMapping("/animal-card")
    public List<AnimalCardResponse> getAnimals() {
        return animalCardService.getAnimals();
    }
}
