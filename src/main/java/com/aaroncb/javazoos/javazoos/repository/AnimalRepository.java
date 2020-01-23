package com.aaroncb.javazoos.javazoos.repository;

import com.aaroncb.javazoos.javazoos.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
}
