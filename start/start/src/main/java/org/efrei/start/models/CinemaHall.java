package org.efrei.start.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class CinemaHall {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "hall_name", nullable = false)
    private String hallName;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @OneToMany(mappedBy = "cinemaHall")
    private List<Place> places;  // Liste des places associées à cette salle de cinéma

    public CinemaHall(String hallName, int capacity) {
        this.hallName = hallName;
        this.capacity = capacity;
    }

    public CinemaHall() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
