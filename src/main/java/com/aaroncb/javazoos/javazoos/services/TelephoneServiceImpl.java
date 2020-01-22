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
        Telephone newTelephone = new Telephone();

        newTelephone.setPhoneType(telephone.getPhoneType());
        newTelephone.setPhoneNumber(telephone.getPhoneNumber());

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
