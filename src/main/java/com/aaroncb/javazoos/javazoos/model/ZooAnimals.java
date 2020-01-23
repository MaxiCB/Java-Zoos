package com.aaroncb.javazoos.javazoos.model;

import com.aaroncb.javazoos.javazoos.model.Animal;
import com.aaroncb.javazoos.javazoos.model.Zoo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="zooanimals",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"zooid", "animalid"})})
public class ZooAnimals extends Auditable implements Serializable
{
//    -- INSERT INTO zooanimals (zooid, animalid, createdby, createddate, lastmodifiedby, lastmodifieddate)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name="animalid")
    @JsonIgnoreProperties("zooanimals")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name="zooid")
    @JsonIgnoreProperties("zooanimals")
    private Zoo zoo;


    public ZooAnimals(){}

    public ZooAnimals(Zoo zoo,
                      Animal animal)
    {
        this.zoo = zoo;
        this.animal = animal;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof ZooAnimals))
        {
            return false;
        }
        ZooAnimals zooAnimals = (ZooAnimals) o;
        return getZoo().equals(zooAnimals.getZoo()) && getAnimal().equals(zooAnimals.getAnimal());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getZoo(),
                getAnimal());
    }

//    @Override
//    public String toString() {
//        return "ZooAnimals{" +
//                ", zoo=" + zoo.getZooID() +
//                ", animal=" + animal.getAnimalID() +
//                '}';
//    }
}
