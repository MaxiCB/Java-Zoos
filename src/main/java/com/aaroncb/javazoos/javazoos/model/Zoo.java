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

//    -- INSERT INTO zoo (zooid, zooname, createdby, createddate, lastmodifiedby, lastmodifieddate)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    @Column(nullable = false,
            unique = true)
    private String zooname;

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("zoo")
    private List<ZooTelphones> teles = new ArrayList<>();

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("zoo")
    private List<ZooAnimals> animals = new ArrayList<>();

    public Zoo(){}

    public Zoo(String zooname, List<ZooTelphones> teles, List<ZooAnimals> animals)
    {
        this.zooname = zooname;
        for(ZooTelphones zt : teles)
    {
        zt.setZoo(this);
    }
        for(ZooAnimals za : animals)
        {
            za.setZoo(this);
        }
        this.teles = teles;
        this.animals= animals;
    }

    public long getZooID() {
        return zooid;
    }

    public void setZooID(long zooid) {
        this.zooid = zooid;
    }

    public String getzooname() {
        return zooname;
    }

    public void setzooname(String zooname) {
        this.zooname = zooname;
    }

    public List<ZooTelphones> getTeles() {
        return teles;
    }

    public void setTeles(List<ZooTelphones> teles) {
        this.teles = teles;
    }

    public List<ZooAnimals> getAnimals() {
        return animals;
    }

    public void setAnimals(List<ZooAnimals> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "zooid=" + zooid +
                ", zooname='" + zooname + '\'' +
                ", teles=" + teles +
                ", animals=" + animals +
                '}';
    }
}
