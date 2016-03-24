package org.example.domain;

import org.example.domain.finder.OrderShipmentFinder;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "or_order_ship")
public class OrderShipment extends BasicDomain {

  public static final OrderShipmentFinder find = new OrderShipmentFinder();

  @ManyToOne
  private Order order;

  private Timestamp shipTime = new Timestamp(System.currentTimeMillis());

  public Timestamp getShipTime() {
    return shipTime;
  }

  public void setShipTime(Timestamp shipTime) {
    this.shipTime = shipTime;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

}
