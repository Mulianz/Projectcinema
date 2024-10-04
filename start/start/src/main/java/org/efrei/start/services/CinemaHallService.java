package org.efrei.start.services;

import org.efrei.start.dto.CreateCinemaHall;
import org.efrei.start.models.CinemaHall;
import org.efrei.start.repositories.CinemaHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaHallService {

    private final CinemaHallRepository repository;

    @Autowired
    public CinemaHallService(CinemaHallRepository repository) {
        this.repository = repository;
    }

    public List<CinemaHall> findAll() {
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    public void create(CreateCinemaHall createCinemaHall) {
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setHallName(createCinemaHall.getHallName());
        cinemaHall.setCapacity(createCinemaHall.getCapacity());
        repository.save(cinemaHall);
    }

    public CinemaHall findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void update(String id, CinemaHall cinemaHall) {
        CinemaHall updatedCinemaHall = findById(id);
        updatedCinemaHall.setHallName(cinemaHall.getHallName());
        updatedCinemaHall.setCapacity(cinemaHall.getCapacity());
        repository.save(updatedCinemaHall);
    }
}
