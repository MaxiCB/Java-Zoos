package com.aaroncb.javazoos.javazoos.model;

import javax.persistence.*;

@Entity
@Table(name="animal")
public class Animal
{

//    -- INSERT INTO animal (animalid, animaltype, createdby, createddate, lastmodifiedby, lastmodifieddate)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;
    private String animaltype;
    private String createdby;
    private long createddate;
    private String lastmodifiedby;
    private long lastmodifieddate;

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
        return "Animal{" +
                "animalid=" + animalid +
                ", animaltype='" + animaltype + '\'' +
                ", createdby='" + createdby + '\'' +
                ", createddate=" + createddate +
                ", lastmodifiedby='" + lastmodifiedby + '\'' +
                ", lastmodifieddate=" + lastmodifieddate +
                '}';
    }
}
