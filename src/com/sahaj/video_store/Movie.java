package com.sahaj.video_store;

public class Movie extends DomainObject {
  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private Price price;

  public Movie(String name, Price price) {
    this.name = name;
    this.price = price;
  }

  public Price price() {
    return price;
  }

  public int priceCode() {
    return price.code();
  }

  public void persist() {
    Registrar.add("Movies", this);
  }

  public static Movie get(String name) {
    return (Movie) Registrar.get("Movies", name);
  }

  double charge(int daysRented) {
    return price.charge(daysRented);
  }

  public static Movie createNewRelease(String name) {
    return new Movie(name, Price.newRelease());
  }

  public static Movie createChildrensRelease(String name) {
    return new Movie(name, Price.childrens());
  }

  public static Movie createRegular(String name) {
    return new Movie(name, Price.regular());
  }

  public int frequentRenterPointsOf(int daysRented) {
    // add bonus for a two day new release rental
    if ((priceCode() == NEW_RELEASE) && daysRented > 1) return 2;
    return 1;
  }
}
