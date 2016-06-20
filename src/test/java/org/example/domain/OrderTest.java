package org.example.domain;

import org.junit.Test;

import java.util.List;

public class OrderTest {

  @Test
  public void test() {

    List<Order> orders = Order.find.where()
        .customer.billingAddress.city.ieq("auckland")
        .details.product.sku.equalTo("C002")
        .setUseDocStore(true)
//        .fetch("customer", "id,name,status")
//        .fetch("customer.billingAddress", "*")
//        .fetch("customer.billingAddress.country", "*")
//        .fetch("details", "*")
//        .fetch("details.product", "id,sku,name")
        .findList();

    orders.size();
    Order firstOrder = orders.get(0);
    firstOrder.getVersion();

//    @DocEmbedded(doc = "id,name,status,billingAddress(*,country(*))")
//    Customer customer;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
//    @DocEmbedded(doc = "*,product(id,sku,name)")
//    List<OrderDetail> details;

  }


  @Test
  public void findNestedFilter() {

    List<Order> orders = Order.find.where()
        .customer.status.eq(Customer.Status.NEW)
        .details.orderQty.greaterThan(4)
        .details.unitPrice.greaterThan(3d)
        .setUseDocStore(true)
        .findList();

    System.out.println("Orders: " + orders);
  }
}
