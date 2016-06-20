package org.example.domain;

import com.avaje.ebean.DocumentStore;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import org.junit.Test;

public class RebuildIndexTest {

  /**
   * Drop and recreate the indexes and populate them.
   */
  @Test
  public void test() {

    System.setProperty("ebean.docstore.generateMapping", "true");
    System.setProperty("ebean.docstore.dropCreate", "true");

    EbeanServer server = Ebean.getDefaultServer();

    DocumentStore documentStore = server.docStore();
    documentStore.indexAll(Country.class);
    documentStore.indexAll(Product.class);
    documentStore.indexAll(Contact.class);
    documentStore.indexAll(Customer.class);
    documentStore.indexAll(Order.class);


//    Map<String,Object> settings = new LinkedHashMap<>();
//    settings.put("refresh_interval", "-1");
//    documentStore.indexSettings("order", settings);
//
//    settings.put("refresh_interval", "1s");
//    documentStore.indexSettings("order", settings);
  }

}
