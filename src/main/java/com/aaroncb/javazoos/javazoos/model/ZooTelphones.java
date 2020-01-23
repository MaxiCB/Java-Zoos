package com.aaroncb.javazoos.javazoos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="zootelephones",
            uniqueConstraints = {@UniqueConstraint(columnNames = {"zooid", "telephoneid"})})
public class ZooTelphones extends Auditable implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties("zootelephones")
    private Zoo zoo;

    @Id
    @ManyToOne
    @JoinColumn(name = "telephoneid")
    @JsonIgnoreProperties("zootelephones")
    private Telephone tele;

    public ZooTelphones()
    {
    }

    public ZooTelphones(Zoo zoo, Telephone tele)
    {
        this.zoo = zoo;
        this.tele = tele;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Telephone getTele() {
        return tele;
    }

    public void setTele(Telephone tele) {
        this.tele = tele;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof ZooTelphones))
        {
            return false;
        }
        ZooTelphones zooTelephones = (ZooTelphones) o;
        return getZoo().equals(zooTelephones.getZoo()) && getTele().equals(zooTelephones.getTele());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getZoo(),
                getTele());
    }

//    @Override
//    public String toString()
//    {
//        return "ZooTelephones{" + "zoo=" + zoo.getZooID() + ", tele=" + tele.getTelephoneID() + '}';
//    }
}
