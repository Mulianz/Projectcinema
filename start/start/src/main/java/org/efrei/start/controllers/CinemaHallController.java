package org.efrei.start.controllers;

import org.efrei.start.dto.CreateCinemaHall;
import org.efrei.start.models.CinemaHall;
import org.efrei.start.services.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema-halls")
public class CinemaHallController {

    private final CinemaHallService service;

    @Autowired
    public CinemaHallController(CinemaHallService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CinemaHall>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CinemaHall> findById(@PathVariable String id) {
        CinemaHall cinemaHall = service.findById(id);
        if (cinemaHall == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cinemaHall, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        CinemaHall cinemaHall = service.findById(id);
        if (cinemaHall == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCinemaHall createCinemaHall) {
        service.create(createCinemaHall);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody CinemaHall cinemaHall) {
        service.update(id, cinemaHall);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
