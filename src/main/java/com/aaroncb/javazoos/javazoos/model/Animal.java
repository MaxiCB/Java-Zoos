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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    private String animaltype;

    @ManyToOne
    @JoinColumn(name = "zooid",
            nullable = false)
    @JsonIgnoreProperties("zoo")
    private Zoo zoo;

    public Animal(){}
    public Animal(Zoo zoo, String animalType){ this.zoo = zoo; this.animaltype = animalType; }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

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

}
