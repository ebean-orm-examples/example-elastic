package org.example.domain;

import com.avaje.ebean.annotation.DocEmbedded;
import com.avaje.ebean.annotation.DocStore;
import com.avaje.ebean.annotation.EnumValue;
import org.example.domain.finder.OrderFinder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * Order entity bean.
 */
@DocStore
@Entity
@Table(name = "o_order")
public class Order extends BasicDomain {

  public static final OrderFinder find = new OrderFinder();

  public enum Status {
    @EnumValue("NEW")
    NEW,

    @EnumValue("APP")
    APPROVED,

    @EnumValue("SHP")
    SHIPPED,

    @EnumValue("COM")
    COMPLETE
  }

  Status status;

  LocalDate orderDate;

  LocalDate shipDate;

  @NotNull
  @ManyToOne
  @DocEmbedded(doc = "id,status,name,billingAddress(*,country(*))")
  Customer customer;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
  @DocEmbedded(doc = "*,product(id,sku,name)")
  List<OrderDetail> details;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
  List<OrderShipment> shipments;

  public Order() {

  }

  public String toString() {
    return "order id:"+id;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public LocalDate getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(LocalDate orderDate) {
    this.orderDate = orderDate;
  }

  public LocalDate getShipDate() {
    return shipDate;
  }

  public void setShipDate(LocalDate shipDate) {
    this.shipDate = shipDate;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public List<OrderDetail> getDetails() {
    return details;
  }

  public void setDetails(List<OrderDetail> details) {
    this.details = details;
  }

  public List<OrderShipment> getShipments() {
    return shipments;
  }

  public void setShipments(List<OrderShipment> shipments) {
    this.shipments = shipments;
  }
}
