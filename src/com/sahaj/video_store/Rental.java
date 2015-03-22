package com.sahaj.video_store;

public class Rental extends DomainObject {
  private Tape tape;
  private int daysRented;

  public Rental(Tape tape, int daysRented) {
    this.tape = tape;
    this.daysRented = daysRented;
  }

  public Tape tape() {
    return tape;
  }

  double charge() {
    return tape.charge(daysRented);
  }

  int frequentRenterPointsOf() {
    return tape.frequentRenterPointsOf(daysRented);
  }
}