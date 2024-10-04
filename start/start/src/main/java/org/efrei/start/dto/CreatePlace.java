package org.efrei.start.dto;

public class CreatePlace {

    private int seatNumber;
    private String row;
    private String cinemaHallId;

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(String cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
}
