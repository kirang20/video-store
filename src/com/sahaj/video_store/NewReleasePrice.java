package com.sahaj.video_store;

public class NewReleasePrice extends Price {
  @Override
  public int code() {
    return Movie.NEW_RELEASE;
  }

  @Override
  public double charge(int daysRented) {
    return daysRented * 3;
  }

  @Override
  public double frequentRenterPoints(int daysRented) {
    if (daysRented > 1) return 2;
    return 1;
  }
}
