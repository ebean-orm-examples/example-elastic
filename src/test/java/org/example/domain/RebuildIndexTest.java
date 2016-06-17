package org.example.domain;

import com.avaje.ebean.DocumentStore;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class RebuildIndexTest {

  @Test
  public void test() {

    System.setProperty("ebean.docstore.generateMapping", "true");
    System.setProperty("ebean.docstore.dropCreate", "true");

    EbeanServer server = Ebean.getDefaultServer();

    Map<String,Object> settings = new LinkedHashMap<>();
    settings.put("refresh_interval", "-1");

    DocumentStore documentStore = server.docStore();
    documentStore.indexSettings("order", settings);

    documentStore.indexAll(Country.class);
    documentStore.indexAll(Product.class);
    documentStore.indexAll(Customer.class);
    documentStore.indexAll(Contact.class);
    documentStore.indexAll(Order.class);

    settings.put("refresh_interval", "1s");
    documentStore.indexSettings("order", settings);
  }

}
