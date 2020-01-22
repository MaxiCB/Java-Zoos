package com.aaroncb.javazoos.javazoos;

import com.aaroncb.javazoos.javazoos.model.Zoo;
import com.aaroncb.javazoos.javazoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

@Transactional
@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    ZooService zooService;

    @Override
    public void run(String[] args) throws Exception {

        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);

        Zoo z1 = new Zoo("Zoo Test 0", "SYSTEM", ts, "", ts);
        Zoo z2 = new Zoo("Zoo Test 1", "SYSTEM", ts, "", ts);
        Zoo z3 = new Zoo("Zoo Test 2", "SYSTEM", ts, "", ts);
    }
}
