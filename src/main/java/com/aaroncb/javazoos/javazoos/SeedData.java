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
    public void run(String[] args) throws Exception
    {
        Zoo z1 = new Zoo("Zooasdfasdf");
        Zoo z2 = new Zoo("Zoosdfsdfsdfsdf");

        z1 = zooService.save(z1);
        z2 = zooService.save(z2);

        z1.getTeles()
                .add(new Telephone(z1, "LANDLINE", "!!!"));
    }
}
