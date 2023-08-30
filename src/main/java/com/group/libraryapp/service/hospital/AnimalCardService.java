package com.group.libraryapp.service.hospital;

import com.group.libraryapp.domain.hospital.AnimalCard;
import com.group.libraryapp.domain.hospital.AnimalCardRepository;
import com.group.libraryapp.dto.hospital.AnimalCardCreateRequest;
import com.group.libraryapp.dto.hospital.AnimalCardResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalCardService {

    private final AnimalCardRepository animalCardRepository;

    public AnimalCardService(AnimalCardRepository animalCardRepository) { this.animalCardRepository = animalCardRepository; }
    public void saveAnimal(AnimalCardCreateRequest request) {
        AnimalCard card = new AnimalCard(request.getName(), request.getAge(), request.getType(), request.getSymptom());
        animalCardRepository.save(card);
    }

    public List<AnimalCardResponse> getAnimals() {
        List<AnimalCard> cards = animalCardRepository.findAll();
        List<AnimalCardResponse> responses = new ArrayList<>();

        for (AnimalCard card : cards) {
            AnimalCardResponse response = new AnimalCardResponse(card);
            responses.add(response);
        }
        return responses;
    }

}
