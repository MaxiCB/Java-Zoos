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

    public Zoo(){}

    public Zoo(String zooname, List<ZooTelphones> teles)
    {
        this.zooname = zooname;
//        for(ZooTelphones zt : teles)
//        {
//            zt.setZoo(this);
//        }
        this.teles = teles;
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

    @Override
    public String toString() {
        return "Zoo{" +
                "zooid=" + zooid +
                ", zooname='" + zooname + '\'' +
                ", teles=" + teles +
                '}';
    }
}
