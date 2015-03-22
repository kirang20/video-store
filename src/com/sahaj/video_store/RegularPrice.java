package com.sahaj.video_store;

public class RegularPrice extends Price {
  @Override
  public int code() {
    return Movie.REGULAR;
  }

  @Override
  public double charge(int daysRented) {
    double amount = 2;
    if (daysRented > 2) {
      amount += (daysRented - 2) * 1.5;
    }
    return amount;
  }

  @Override
  public double frequentRenterPoints(int daysRented) {
    return 1;
  }
}
