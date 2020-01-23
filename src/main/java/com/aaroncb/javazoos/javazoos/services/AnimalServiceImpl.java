package com.aaroncb.javazoos.javazoos.services;

import com.aaroncb.javazoos.javazoos.model.Animal;
import com.aaroncb.javazoos.javazoos.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="animalService")
public class AnimalServiceImpl implements AnimalService
{

    @Autowired
    private AnimalRepository animalRepository;


    @Override
    public Animal save(Animal animal) {
        Animal newAnimal = new Animal();

        newAnimal.setAnimalType(animal.getAnimalType());

        return animalRepository.save(newAnimal);
    }
}
