package com.aaroncb.javazoos.javazoos;

import com.aaroncb.javazoos.javazoos.model.*;
import com.aaroncb.javazoos.javazoos.services.AnimalService;
import com.aaroncb.javazoos.javazoos.services.TelephoneService;
import com.aaroncb.javazoos.javazoos.services.ZooService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

@Transactional
@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    ZooService zooService;

    @Autowired
    TelephoneService telephoneService;

    @Autowired
    AnimalService animalService;

    @Override
    public void run(String[] args) throws Exception {

        Telephone t1 = new Telephone("LANDLINE", "111");
        Telephone t2 = new Telephone("FAX", "222");
        Telephone t3 = new Telephone("MOBILE", "333");

        Animal a1 = new Animal("Test Animal Type 01");
        Animal a2 = new Animal("Test Animal Type 02");
        Animal a3 = new Animal("Test Animal Type 02");

        t1 = telephoneService.save(t1);
        t2 = telephoneService.save(t2);
        t3 = telephoneService.save(t3);
        a1 = animalService.save(a1);
        a2 = animalService.save(a2);
        a3 = animalService.save(a3);


        ArrayList<ZooTelphones> zooTeles = new ArrayList<>();

        ArrayList<ZooAnimals> zooAnimals = new ArrayList<>();

        Zoo z1 = new Zoo("Testing Zoo No Tele", new ArrayList<ZooTelphones>(), new ArrayList<ZooAnimals>());
        z1 = zooService.save(z1);
        System.out.println("Zoo Without Telephone: " + z1 + "\n");

        Zoo z2 = new Zoo("Testing Zoo With Tele", new ArrayList<ZooTelphones>(), new ArrayList<ZooAnimals>());
        z2 = zooService.save(z2);

        Zoo z3 = new Zoo("Testing Zoo With Tele and Animals", new ArrayList<ZooTelphones>(), new ArrayList<ZooAnimals>());
        z3 = zooService.save(z3);

        zooTeles.add(new ZooTelphones(new Zoo(), t1));
        zooTeles.add(new ZooTelphones(new Zoo(), t2));
        zooTeles.add(new ZooTelphones(new Zoo(), t3));

        zooAnimals.add(new ZooAnimals(new Zoo(), a1));
        zooAnimals.add(new ZooAnimals(new Zoo(), a2));
        zooAnimals.add(new ZooAnimals(new Zoo(), a3));

        z2.getTeles()
                .add(new ZooTelphones(z2, t1));
        z2.getTeles()
                .add(new ZooTelphones(z2, t2));
        z2.getTeles()
                .add(new ZooTelphones(z2, t3));

        z3.getTeles()
                .add(new ZooTelphones(z3, t1));
        z3.getTeles()
                .add(new ZooTelphones(z3, t2));
        z3.getTeles()
                .add(new ZooTelphones(z3, t3));

        z3.getAnimals()
                .add(new ZooAnimals(z3, a1));
        z3.getAnimals()
                .add(new ZooAnimals(z3, a2));
        z3.getAnimals()
                .add(new ZooAnimals(z3, a3));

        System.out.println(z2.toString());
    }
}
