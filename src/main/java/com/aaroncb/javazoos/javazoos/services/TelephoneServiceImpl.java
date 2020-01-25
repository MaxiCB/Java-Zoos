package com.aaroncb.javazoos.javazoos.services;

import com.aaroncb.javazoos.javazoos.model.Telephone;
import com.aaroncb.javazoos.javazoos.model.Zoo;
import com.aaroncb.javazoos.javazoos.repository.TelephoneRepository;
import org.hibernate.dialect.function.AbstractAnsiTrimEmulationFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value="telephoneService")
public class TelephoneServiceImpl implements TelephoneService
{

    @Autowired
    private TelephoneRepository telephoneRepository;

    @Autowired ZooService zooService;

    @Override
public List<Telephone> findAll() {
    List<Telephone> telephones = new ArrayList<>();
    telephoneRepository.findAll()
            .iterator()
            .forEachRemaining(telephones::add);
    return telephones;
}

    @Override
    public Telephone findByID(long id) throws EntityNotFoundException {
        return telephoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Telephone " + Long.toString(id) + " not found"));
    }

    @Transactional
    @Override
    public Telephone save(Telephone telephone) {

        Zoo zoo = zooService.findByID(telephone.getZoo().getZooID());


        Telephone newTelephone = new Telephone(zoo, telephone.getPhoneType(), telephone.getPhoneNumber());

        return telephoneRepository.save(newTelephone);
    }

    @Override
    public Telephone update(Telephone telephone) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
