package com.aaroncb.javazoos.javazoos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="animal")
public class Animal
{

//    -- INSERT INTO animal (animalid, animaltype, createdby, createddate, lastmodifiedby, lastmodifieddate)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;
    private String animaltype;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("animal")
    @JsonIgnore
    private List<ZooAnimals> animals = new ArrayList<>();

    public Animal(){}
    public Animal(String animalType){ this.animaltype = animalType; }

    public long getAnimalID() {
        return animalid;
    }

    public void setAnimalID(long animalID) {
        this.animalid = animalID;
    }

    public String getAnimalType() {
        return animaltype;
    }

    public void setAnimalType(String animalType) {
        this.animaltype = animalType;
    }

    public List<ZooAnimals> getAnimals() {
        return animals;
    }

    public void setAnimals(List<ZooAnimals> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalid=" + animalid +
                ", animaltype='" + animaltype + '\'' +
                ", animals=" + animals +
                '}';
    }
}
