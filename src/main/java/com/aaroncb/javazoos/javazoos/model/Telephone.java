package com.aaroncb.javazoos.javazoos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="telephone")
public class Telephone
{
//    -- INSERT INTO telephone(phoneid, phonetype, phonenumber, zooid, createdby, createddate, lastmodifiedby, lastmodifieddate)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long telephoneid;
    private String phonetype;
    private String phonenumber;

    @OneToMany(mappedBy = "zooid",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    @JsonIgnoreProperties("zoo")
    private List<Zoo> zoo = new ArrayList<>();

    private String createdby;
    private long createddata;
    private String lastmodifiedby;
    private long lastmodifieddate;

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

    public List<Zoo> getZoo() {
        return zoo;
    }

    public void setZoo(List<Zoo> zoo) {
        this.zoo = zoo;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public long getCreateddata() {
        return createddata;
    }

    public void setCreateddata(long createddata) {
        this.createddata = createddata;
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
        return "Telephone{" +
                "telephoneid=" + telephoneid +
                ", phonetype='" + phonetype + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", zoo=" + zoo +
                ", createdby='" + createdby + '\'' +
                ", createddata=" + createddata +
                ", lastmodifiedby='" + lastmodifiedby + '\'' +
                ", lastmodifieddate=" + lastmodifieddate +
                '}';
    }
}
