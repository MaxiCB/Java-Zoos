package com.aaroncb.javazoos.javazoos.services;

import com.aaroncb.javazoos.javazoos.model.Animal;

public interface AnimalService
{
    Animal save(Animal animal);

    void delete(long id);
}
