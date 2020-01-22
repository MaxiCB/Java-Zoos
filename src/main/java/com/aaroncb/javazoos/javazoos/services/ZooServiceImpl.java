package com.aaroncb.javazoos.javazoos.services;

import com.aaroncb.javazoos.javazoos.model.Zoo;
import com.aaroncb.javazoos.javazoos.repository.ZooRepository;
import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import org.h2.util.CurrentTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    private ZooRepository zooRepository;

    @Override
    public List<Zoo> findAll() {
        List<Zoo> zoos = new ArrayList<>();
        zooRepository.findAll()
                    .iterator()
                    .forEachRemaining(zoos::add);
        return zoos;
    }

    @Override
    public Zoo findByID(long id) throws EntityNotFoundException {
        return zooRepository.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException("Zoo " + Long.toString(id) + " not found"));
    }

    @Override
    public List<Zoo> findByNameLike(String name) {
        return zooRepository.findByZoonameContaining(name.toLowerCase());
    }
    @Transactional
    @Override
    public Zoo save(Zoo zoo) {
        Zoo newZoo = new Zoo();

        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);

        newZoo.setCreatedby(zoo.getCreatedby());
        newZoo.setCreateddate(ts);
        newZoo.setLastmodifiedby(zoo.getCreatedby());
        newZoo.setLastmodifieddate(ts);
        newZoo.setzooname(zoo.getzooname());

        return zooRepository.save(newZoo);
    }

    @Transactional
    @Override
    public Zoo update(Zoo zoo, long id) {
        Zoo currentZoo = findByID(id);

        if(zoo.getLastmodifiedby() != null){currentZoo.setLastmodifiedby(zoo.getLastmodifiedby());};
        if(zoo.getzooname() != null){currentZoo.setzooname(zoo.getzooname());};

        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);

        zoo.setLastmodifieddate(ts);

        return zooRepository.save(currentZoo);
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException {
        zooRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("User " + Long.toString(id) + " not found"));
        zooRepository.deleteById(id);
    }

    @Override
    public int getZooCount(){
        return zooRepository.getZooCount();
    }

}
