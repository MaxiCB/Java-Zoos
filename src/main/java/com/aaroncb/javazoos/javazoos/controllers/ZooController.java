package com.aaroncb.javazoos.javazoos.controllers;

import com.aaroncb.javazoos.javazoos.model.Zoo;
import com.aaroncb.javazoos.javazoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;

    @GetMapping(value="/zoos",
                produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        List<Zoo> zoos = zooService.findAll();
        return new ResponseEntity<>(zoos, HttpStatus.OK);
    }

    @GetMapping(value="/zoo/{id}",
            produces = {"application/json"})
    public ResponseEntity<?> getZooById(
            @PathVariable long id)
    {
        Zoo zoo = zooService.findByID(id);
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

    @GetMapping(value="/zoo/namelike/{name}",
            produces = {"application/json"})
    public ResponseEntity<?> getZooLikeName(
            @PathVariable String name)
    {
        List<Zoo> zoos = zooService.findByNameLike(name);
        return new ResponseEntity<>(zoos, HttpStatus.OK);
    }

    @GetMapping(value="/zoo/count",
                produces = {"application/json"})
    public ResponseEntity<?> getZooCount()
    {
        int count = zooService.getZooCount();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @PostMapping(value = "/zoo",
            consumes = {"application/json"})
    public ResponseEntity<?> addNewZoo(@Valid
                                        @RequestBody
                                                Zoo newZoo) throws URISyntaxException
    {
        newZoo = zooService.save(newZoo);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newZooURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{zooid}")
                .buildAndExpand(newZoo.getZooID())
                .toUri();
        responseHeaders.setLocation(newZooURI);

        return new ResponseEntity<>(null,
                responseHeaders,
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/zoo/{id}",
            consumes = {"application/json"})
    public ResponseEntity<?> updateZoo(
            @RequestBody
                    Zoo updateZoo,
            @PathVariable
                    long id)
    {
        zooService.update(updateZoo,
                id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "/zoo/{id}")
    public ResponseEntity<?> deleteZooById(
            @PathVariable
                    long id)
    {
        zooService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
