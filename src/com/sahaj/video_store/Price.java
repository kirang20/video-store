package com.sahaj.video_store;

public abstract class Price {
  static Price regular() {
    return new RegularPrice();
  }

  static Price childrens() {
    return new ChildrensPrice();
  }

  static Price newRelease() {
    return new NewReleasePrice();
  }

  public abstract int code();
  public abstract double charge(int daysRented);
  public abstract double frequentRenterPoints(int daysRented);
}
