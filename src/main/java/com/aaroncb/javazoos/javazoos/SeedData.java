package com.aaroncb.javazoos.javazoos;

import com.aaroncb.javazoos.javazoos.model.Telephone;
import com.aaroncb.javazoos.javazoos.model.Zoo;
import com.aaroncb.javazoos.javazoos.model.ZooTelphones;
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

    @Override
    public void run(String[] args) throws Exception {

        Telephone t1 = new Telephone("LANDLINE", "111");
        Telephone t2 = new Telephone("FAX", "222");
        Telephone t3 = new Telephone("MOBILE", "333");

        t1 = telephoneService.save(t1);
        t2 = telephoneService.save(t2);
        t3 = telephoneService.save(t3);

        System.out.println(telephoneService.findAll());

        ArrayList<ZooTelphones> zooTeles = new ArrayList<>();

        Zoo z1 = new Zoo("Testing Zoo", new ArrayList<ZooTelphones>());
        z1 = zooService.save(z1);

        zooTeles.add(new ZooTelphones(new Zoo(), t1));
        zooTeles.add(new ZooTelphones(new Zoo(), t2));
        zooTeles.add(new ZooTelphones(new Zoo(), t3));

        z1.getTeles()
                .add(new ZooTelphones(z1, t1));
        z1.getTeles()
                .add(new ZooTelphones(z1, t2));
        z1.getTeles()
                .add(new ZooTelphones(z1, t3));

        System.out.println(z1.toString());
    }
}
