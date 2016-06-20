package org.example.domain;


import com.avaje.ebean.PagedList;
import com.avaje.ebean.search.MultiMatch;
import org.example.domain.query.QOrder;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.example.domain.Order.Status.COMPLETE;
import static org.example.domain.Order.Status.SHIPPED;

public class ProductTest {

  @Test
  public void findBySku() {

    Product c002 = Product.find.where()
        .sku.equalTo("C002")
        .setUseDocStore(true)
        .findUnique();

    System.out.println("got: " + c002);
  }














  @Test
  public void useDocStore() {


//    new QProduct()
//        .name.icontains("cha")
//        .findList();
//
////    Order.find.where().setUseDocStore(true).findList();
////
//    Product.find
//        .where()
//        .sku.equalTo("C002")
//        .setUseDocStore(true)
//        .findList();



    Country nz = Country.find.ref("NZ");

    LocalDate recent = LocalDate.now().minusDays(50);

    new Date(System.currentTimeMillis());

    Order.find.where()
        .customer.billingAddress.country.name.istartsWith("new")
        .orderDate.after(recent)
        .status.in(SHIPPED)
        .customer.billingAddress.country.code.eq("NZ")
        .setUseDocStore(true)
        .findList();

    if (true) {
      return;
    }

//    Order.find
//
//          .where()
//
//          .customer.name.match("Rob")
//        .where()
//          .status.eq(Order.Status.COMPLETE)
//          .findList();

//    List<Order> orders = Order.find
//        .where()
//        .setUseDocStore(true)
//        .setFirstRow(10)
//        .setMaxRows(10)
//        .status.eq(Order.Status.COMPLETE)
//        .orderBy()
//          .whenCreated.desc()
//        .findList();
  }

  @Test
  public void where() {

    PagedList<Order> orders =
        Order.find
            .text()
            .customer.name.match("Rob")
            .status.eq(COMPLETE)
            .setMaxRows(50)
            .findPagedList();

    Product.find
        .where()
        .sku.equalTo("C002")
        .findList();

    //@formatter:off
    List<Order> orders2 = Order.find
      .text()
        .must()
          .customer.name.match("Rob")
          .customer.name.match("Bygr")
          .endJunction()
        .mustNot()
          .customer.status.eq(Customer.Status.ACTIVE)
          //.endJunction()
      .where()
          .should()
            .status.eq(COMPLETE)
            .status.isNotNull()
            .findList();



    if (true) {
      return;
    }

    MultiMatch multiMatch = MultiMatch.fields("customer.name", "customer.smallNotes")
        .opAnd()
        .type(MultiMatch.Type.PHRASE_PREFIX);

    new QOrder()
        .multiMatch("Rob", multiMatch)
        .findList();



    new QOrder()
        .multiMatch("Rob", "customer.name", "customer.smallNotes")
        .status.eq(COMPLETE)
        .findList();



    new QOrder()
        .customer.name.match("Rob")
        .status.eq(COMPLETE)
        .findList();

    new QOrder()
        .must()
          .customer.name.match("Rob")
//        .endMust()
//        .should()
//          .customer.name.match("Bygr")
          .status.eq(COMPLETE)
//        .where()
//          .status.eq(Order.Status.COMPLETE)

        .findList();

//    Product
//        .where()
//        .name.match("Rob")
//        .sku.equalTo("C001")
//        .findList();
//
//    List<Product> products = Product.where()
//        .name.contains("chair")
//        .findList();
//
//    products.forEach(product -> product.getName());
  }
}