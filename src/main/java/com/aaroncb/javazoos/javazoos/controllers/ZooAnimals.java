package com.aaroncb.javazoos.javazoos.controllers;

import com.aaroncb.javazoos.javazoos.model.Animal;
import com.aaroncb.javazoos.javazoos.model.Zoo;

import javax.persistence.*;

@Entity
@Table(name="zooanimals")
public class ZooAnimals
{
//    -- INSERT INTO zooanimals (zooid, animalid, createdby, createddate, lastmodifiedby, lastmodifieddate)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooanimal;

    @OneToOne
    @JoinColumn(name="zooid")
    private Zoo zoo;

    @OneToOne
    @JoinColumn(name="animalid")
    private Animal animal;

    private String createdby;
    private long createddate;
    private String lastmodifiedby;
    private long lastmodifieddate;

    public ZooAnimals(){}

    public ZooAnimals(Zoo zoo,
                      Animal animal,
                      String createdby,
                      long createddate,
                      String lastmodifiedby,
                      long lastmodifieddate)
    {
        this.zoo = zoo;
        this.animal = animal;
        this.createdby = createdby;
        this.createddate = createddate;
        this.lastmodifiedby = lastmodifiedby;
        this.lastmodifieddate = lastmodifieddate;
    }

    public long getZooanimal() {
        return zooanimal;
    }

    public void setZooanimal(long zooanimal) {
        this.zooanimal = zooanimal;
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

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public long getCreateddate() {
        return createddate;
    }

    public void setCreateddate(long createddate) {
        this.createddate = createddate;
    }

    public String getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }

    public long getLastmodifieddate() {
        return lastmodifieddate;
    }

    public void setLastmodifieddate(long lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    @Override
    public String toString() {
        return "ZooAnimals{" +
                "zooanimal=" + zooanimal +
                ", zoo=" + zoo +
                ", animal=" + animal +
                ", createdby='" + createdby + '\'' +
                ", createddate=" + createddate +
                ", lastmodifiedby='" + lastmodifiedby + '\'' +
                ", lastmodifieddate=" + lastmodifieddate +
                '}';
    }
}
