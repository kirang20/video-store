package com.sahaj.video_store;

public class ChildrensPrice extends Price {
  @Override
  public int code() {
    return Movie.CHILDRENS;
  }

  @Override
  public double charge(int daysRented) {
    double amount = 1.5;
    if (daysRented > 3)
      amount += (daysRented - 3) * 1.5;
    return amount;
  }

  @Override
  public double frequentRenterPoints(int daysRented) {
    return 1;
  }
}
