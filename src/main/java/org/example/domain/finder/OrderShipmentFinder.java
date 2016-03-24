package org.example.domain.finder;

import com.avaje.ebean.Finder;
import org.example.domain.OrderShipment;
import org.example.domain.query.QOrderShipment;

public class OrderShipmentFinder extends Finder<Long,OrderShipment> {

  /**
   * Construct using the default EbeanServer.
   */
  public OrderShipmentFinder() {
    super(OrderShipment.class);
  }

  /**
   * Construct with a given EbeanServer.
   */
  public OrderShipmentFinder(String serverName) {
    super(OrderShipment.class, serverName);
  }

  /**
   * Start a new typed query.
   */
  protected QOrderShipment where() {
     return new QOrderShipment(db());
  }
}
