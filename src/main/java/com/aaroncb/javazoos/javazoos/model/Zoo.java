package com.aaroncb.javazoos.javazoos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="zoo")
public class Zoo
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    @Column(nullable = false,
            unique = true)
    private String zooname;

    @OneToMany(mappedBy = "zoo",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("zoo")
    private List<Telephone> teles = new ArrayList<>();

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("zoo")
    private List<Animal> animals = new ArrayList<>();


    public Zoo(){}

    public Zoo(String zooname)
    {
        this.zooname = zooname;
    }

    public long getZooID() {
        return zooid;
    }

    public void setZooID(long zooid) {
        this.zooid = zooid;
    }

    public String getzooname() {
        if(zooname == null){
            return null;
        } else {
            return zooname.toLowerCase();
        }
    }

    public void setzooname(String zooname) {
        this.zooname = zooname.toLowerCase();
    }

    public List<Telephone> getTeles() {
        return teles;
    }

    public void setTeles(List<Telephone> teles) {
        this.teles = teles;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

}
