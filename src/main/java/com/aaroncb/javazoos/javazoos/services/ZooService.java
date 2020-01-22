package com.aaroncb.javazoos.javazoos.services;

import com.aaroncb.javazoos.javazoos.model.Zoo;

import java.util.List;

public interface ZooService
{

    List<Zoo> findAll();

    Zoo findByID(long id);

    List <Zoo> findByNameLike(String name);

    Zoo save(Zoo zoo);

    Zoo update(Zoo zoo, long id);

    void delete(long id);

    int getZooCount();
}
