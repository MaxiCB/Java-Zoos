package com.aaroncb.javazoos.javazoos.model;

import com.aaroncb.javazoos.javazoos.model.Animal;
import com.aaroncb.javazoos.javazoos.model.Zoo;

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
    @ManyToOne
    @JoinColumn(name="zooid")
    private Zoo zoo;

    @ManyToOne
    @JoinColumn(name="animalid")
    private Animal animal;

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

    @Override
    public String toString() {
        return "ZooAnimals{" +
                ", zoo=" + zoo.getZooID() +
                ", animal=" + animal.getAnimalID() +
                '}';
    }
}
