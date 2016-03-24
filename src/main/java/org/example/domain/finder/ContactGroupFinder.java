package org.example.domain.finder;

import com.avaje.ebean.Finder;
import org.example.domain.ContactGroup;
import org.example.domain.query.QContactGroup;

public class ContactGroupFinder extends Finder<Long,ContactGroup> {

  /**
   * Construct using the default EbeanServer.
   */
  public ContactGroupFinder() {
    super(ContactGroup.class);
  }

  /**
   * Construct with a given EbeanServer.
   */
  public ContactGroupFinder(String serverName) {
    super(ContactGroup.class, serverName);
  }

  /**
   * Start a new typed query.
   */
  protected QContactGroup where() {
     return new QContactGroup(db());
  }
}
