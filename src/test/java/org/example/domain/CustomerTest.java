package org.example.domain;

import org.junit.Test;

import java.util.List;

public class CustomerTest {

  @Test
  public void findJoin() {

    List<Customer> customers = Customer.find
        .where()
          .billingAddress.id.isNotNull()
        .order()
          .name.desc()
        .setUseDocStore(true)
        .findList();

    Customer first = customers.get(0);
    first.getName();

    System.out.println("getContacts...");
    List<Contact> contacts = first.getContacts();
    contacts.size();

    System.out.println("getShippingAddress...");
    Address shippingAddress = first.getShippingAddress();
    shippingAddress.getCity();
    first.getName();

  }

  @Test
  public void findNoContacts() {

    List<Customer> customers = Customer.find.where()
        .contacts.isEmpty()
        //.name.istartsWith("r")
        //.status.isNotNull()
        //.contacts.firstName.istartsWith("jim")
        //.contacts.lastName.istartsWith("cric")
        //.contacts.isNotEmpty()
        //.contacts.id.isNull()
        .setUseDocStore(true)
        .findList();

    customers.size();
  }
}
