package org.example.domain;

import org.junit.Test;

import java.util.List;

public class CountryTest {

  @Test
  public void findAll() {

    List<Country> countries = Country.find.docStoreAll();
    System.out.println(countries);
  }
}