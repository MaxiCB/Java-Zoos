package com.aaroncb.javazoos.javazoos.services;

import com.aaroncb.javazoos.javazoos.model.Telephone;
import com.aaroncb.javazoos.javazoos.model.Zoo;

import java.util.List;

public interface TelephoneService
{
    List<Telephone> findAll();

    Telephone findByID(long id);

    Telephone save(Telephone telephone);

    Telephone update(Telephone telephone);

    void delete(long id);
}
