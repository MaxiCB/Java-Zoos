package com.aaroncb.javazoos.javazoos.services;

import com.aaroncb.javazoos.javazoos.model.Animal;
import com.aaroncb.javazoos.javazoos.model.Telephone;
import com.aaroncb.javazoos.javazoos.model.Zoo;
import com.aaroncb.javazoos.javazoos.repository.AnimalRepository;
import com.aaroncb.javazoos.javazoos.repository.TelephoneRepository;
import com.aaroncb.javazoos.javazoos.repository.ZooRepository;
import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import org.h2.util.CurrentTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    private ZooRepository zooRepository;

    @Autowired
    TelephoneRepository telephoneRepository;

    @Autowired
    AnimalRepository animalRepository;

    @Override
    public List<Zoo> findAll() {
        List<Zoo> zoos = new ArrayList<>();
        zooRepository.findAll()
                    .iterator()
                    .forEachRemaining(zoos::add);
        return zoos;
    }

    @Override
    public Zoo findByID(long id) throws EntityNotFoundException {
        return zooRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Zoo " + Long.toString(id) + " not found"));
    }

    @Override
    public List<Zoo> findByNameLike(String name) {
        return zooRepository.findZooByzooname(name.toLowerCase());
    }

    @Transactional
    @Override
    public Zoo save(Zoo zoo) {

//        if(zooRepository.findZooByzooname(zoo.getzooname().toLowerCase()) != null)
//        {
//            throw new EntityNotFoundException(zoo.getzooname() + " is already taken!");
//        }

        Zoo newZoo = new Zoo();
        newZoo.setzooname(zoo.getzooname().toLowerCase());

        ArrayList<Telephone> teles = new ArrayList<>();

        for(Telephone tp : zoo.getTeles())
        {
            long id = tp.getTelephoneID();
            Telephone telephone = telephoneRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Telephone with that id" + id + " not found!"));
            teles.add(telephone);
        }

        newZoo.setTeles(teles);

        ArrayList<Animal> animals = new ArrayList<>();

        for(Animal am : zoo.getAnimals())
        {
            long id = am.getAnimalID();
            Animal animal = animalRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Animal with id " + id + " not found!"));
            animals.add(animal);
        }

        newZoo.setAnimals(animals);

        return zooRepository.save(newZoo);
    }

    @Transactional
    @Override
    public Zoo update(Zoo zoo, long id) {
        Zoo currentZoo = findByID(id);

        if(zoo.getzooname() != null){currentZoo.setzooname(zoo.getzooname());};

        if(zoo.getAnimals() != null){currentZoo.setAnimals(zoo.getAnimals());};

        if(zoo.getTeles() != null){currentZoo.setTeles(zoo.getTeles());};

        return zooRepository.save(currentZoo);
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException {
        zooRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("User " + Long.toString(id) + " not found"));
        zooRepository.deleteById(id);
    }

    @Override
    public int getZooCount(){
        return zooRepository.getZooCount();
    }

}
