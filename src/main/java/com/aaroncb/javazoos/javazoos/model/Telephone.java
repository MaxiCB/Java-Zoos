package com.aaroncb.javazoos.javazoos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="telephone",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"zooid", "phonetype"})})
public class Telephone extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long telephoneid;

    private String phonetype;
    private String phonenumber;


    @ManyToOne
    @JoinColumn(name = "zooid",
            nullable = false)
    @JsonIgnore
    private Zoo zoo;

    public Telephone() {}

    public Telephone(Zoo zoo,
                     String phonetype,
                     String phonenumber) {
        this.zoo = zoo;
        this.phonetype = phonetype;
        this.phonenumber = phonenumber;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
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
}
