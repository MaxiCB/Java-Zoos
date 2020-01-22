package com.aaroncb.javazoos.javazoos.model;

import org.springframework.data.domain.Auditable;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="zoo")
public class Zoo
{

//    -- INSERT INTO zoo (zooid, zooname, createdby, createddate, lastmodifiedby, lastmodifieddate)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;
    private String zooname;
    private String createdby;
    private Timestamp createddate;
    private String lastmodifiedby;
    private Timestamp lastmodifieddate;

    public Zoo(){}
    public Zoo(String zooname, String createdby, Timestamp createddate, String lastmodifiedby, Timestamp lastmodifieddate)
    {
        this.zooname = zooname;
        this.createdby = createdby;
        this.createddate = createddate;
        this.lastmodifiedby = lastmodifiedby;
        this.lastmodifieddate = lastmodifieddate;
    }

    public long getZooID() {
        return zooid;
    }

    public void setZooID(long zooID) {
        this.zooid = zooID;
    }

    public String getzooname() {
        return zooname;
    }

    public void setzooname(String zooname) {
        this.zooname = zooname;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    public String getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }

    public Timestamp getLastmodifieddate() {
        return lastmodifieddate;
    }

    public void setLastmodifieddate(Timestamp lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "zooid=" + zooid +
                ", zooname='" + zooname + '\'' +
                ", createdby='" + createdby + '\'' +
                ", createddate=" + createddate +
                ", lastmodifiedby='" + lastmodifiedby + '\'' +
                ", lastmodifieddate=" + lastmodifieddate +
                '}';
    }
}
