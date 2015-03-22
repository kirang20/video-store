package com.sahaj.video_store;

public class Tape extends DomainObject {
  private String serialNumber;
  Movie movie;

  public Tape(String serialNumber, Movie movie) {
    this.serialNumber = serialNumber;
    this.movie = movie;
  }

  public Movie movie() {
    return movie;
  }

  public double charge(int daysRented) {
    return movie.charge(daysRented);
  }

  public int frequentRenterPointsOf(int daysRented) {
    return movie.frequentRenterPointsOf(daysRented);
  }
}