package com.aaroncb.javazoos.javazoos.services;

import com.aaroncb.javazoos.javazoos.model.Animal;
import com.aaroncb.javazoos.javazoos.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service(value="animalService")
public class AnimalServiceImpl implements AnimalService
{

    @Autowired
    private AnimalRepository animalRepository;


    @Transactional
    @Override
    public Animal save(Animal animal) {
        Animal newAnimal = new Animal();

        newAnimal.setAnimalType(animal.getAnimalType());

        return animalRepository.save(newAnimal);
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal with id " + id + " not found!"));
        animalRepository.deleteById(id);
    }
}
