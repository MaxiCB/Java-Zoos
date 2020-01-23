package com.aaroncb.javazoos.javazoos.repository;

import com.aaroncb.javazoos.javazoos.model.Zoo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZooRepository extends CrudRepository<Zoo, Long> {

    List<Zoo> findByZoonameContainingIgnoringCase(String name);

    @Query(value = "SELECT COUNT(ZOONAME) FROM ZOO",
            nativeQuery = true)
    int getZooCount();
}
