package com.aaroncb.javazoos.javazoos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="telephone")
public class Telephone extends Auditable
{
//    -- INSERT INTO telephone(phoneid, phonetype, phonenumber, zooid, createdby, createddate, lastmodifiedby, lastmodifieddate)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long telephoneid;
    private String phonetype;
    private String phonenumber;

    @OneToMany(mappedBy = "tele", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("tele")
    @JsonIgnore
    private List<ZooTelphones> teles = new ArrayList<>();

    public Telephone() {}

    public Telephone(
                     String phonetype,
                     String phonenumber) {
        this.phonetype = phonetype;
        this.phonenumber = phonenumber;
    }

    public List<ZooTelphones> getTeles() {
        return teles;
    }

    public void setTeles(List<ZooTelphones> teles) {
        this.teles = teles;
    }

    public long getTelephoneID() {
        return telephoneid;
    }

    public void setTelephoneID(long telephoneID) {
        this.telephoneid = telephoneID;
    }

    public String getPhoneType() {
        return phonetype;
    }

    public void setPhoneType(String phoneType) {
        this.phonetype = phoneType;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Telephone{" +
                "telephoneid=" + telephoneid +
                ", phonetype='" + phonetype + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", teles=" + teles +
                '}';
    }
}
