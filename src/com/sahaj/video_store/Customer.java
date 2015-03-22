package com.sahaj.video_store;

import java.util.ArrayList;
import java.util.List;

public class Customer extends DomainObject {
  private List<Rental> rentals = new ArrayList<Rental>();

  public Customer(String name) {
    this.name = name;
  }

  public String statement() {
    String result = "Rental Record for " + name() + "\n";
    for (Rental each : rentals) {
      //show figures for this rental
      result += "\t" + each.tape().movie().name() + "\t" + String.valueOf(each.charge()) + "\n";
    }

    //add footer lines
    result += "Amount owed is " + String.valueOf(charge()) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints()) + " frequent renter points";
    return result;
  }

  public String htmlStatement() {
    String result = "<H1>Rentals for <EM>" + name() + "</EM></H1><P>\n";
    for (Rental rental : rentals) {
      result += rental.tape().movie().name() + ": " +
              String.valueOf(rental.charge()) + "<BR>\n";

    }
    //add footer lines
    result += "<P>You owe <EM>" + String.valueOf(charge()) + "</EM><P>\n";
    result += "On this rental you earned <EM>" + String.valueOf(frequentRenterPoints()) + "</EM> frequent renter points<P>";
    return result;
  }

  private double charge() {
    double result = 0;
    for (Rental rental : rentals) {
      result += rental.charge();
    }
    return result;
  }

  private double frequentRenterPoints() {
    double result = 0;
    for (Rental rental : rentals) {
      result += rental.frequentRenterPointsOf();
    }
    return result;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public static Customer get(String name) {
    return (Customer) Registrar.get("Customers", name);
  }

  public void persist() {
    Registrar.add("Customers", this);
  }
}