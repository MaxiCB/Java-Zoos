package com.aaroncb.javazoos.javazoos.model;

import org.springframework.data.domain.Auditable;

import javax.persistence.*;

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
    private long createddate;
    private String lastmodifiedby;
    private long lastmodifieddate;

    public Zoo(){}
    public Zoo(String zooName, String createdby, long createddate, String lastmodifiedby, long lastmodifieddate)
    {
        this.zooname = zooName;
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

    public String getZooName() {
        return zooname;
    }

    public void setZooName(String zooName) {
        this.zooname = zooName;
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
