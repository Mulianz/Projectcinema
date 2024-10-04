package org.efrei.start.services;

import org.efrei.start.dto.CreatePlace;
import org.efrei.start.models.Place;
import org.efrei.start.models.CinemaHall;
import org.efrei.start.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository repository;
    private final CinemaHallService cinemaHallService;

    @Autowired
    public PlaceService(PlaceRepository repository, CinemaHallService cinemaHallService) {
        this.repository = repository;
        this.cinemaHallService = cinemaHallService;
    }

    public List<Place> findAll() {
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    public void create(CreatePlace createPlace) {
        Place place = new Place();
        CinemaHall cinemaHall = cinemaHallService.findById(createPlace.getCinemaHallId());
        place.setSeatNumber(createPlace.getSeatNumber());
        place.setRow(createPlace.getRow());
        place.setCinemaHall(cinemaHall);
        repository.save(place);
    }

    public Place findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Place place) {
        Place updatedPlace = findById(id);
        updatedPlace.setSeatNumber(place.getSeatNumber());
        updatedPlace.setRow(place.getRow());
        repository.save(updatedPlace);
    }
}
