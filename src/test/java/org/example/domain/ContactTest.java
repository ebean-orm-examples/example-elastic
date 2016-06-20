package org.example.domain;

import com.avaje.ebean.search.MultiMatch;
import org.junit.Test;

public class ContactTest {

  @Test
  public void findWithCustomerName() {

    Contact.find.where()
        .customer.name.istartsWith("ro")
        .lastName.istartsWith("crick")
        .setUseDocStore(true)
        .findList();


    MultiMatch multiMatch = new MultiMatch("firstName", "lastName", "customer.name")
        .type(MultiMatch.Type.CROSS_FIELDS)
        .opAnd();

    Contact.find.where()
        .multiMatch("cricket rob", multiMatch)
        .findList();

  }
}
