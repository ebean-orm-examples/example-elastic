package org.example.domain;

import org.example.domain.finder.ContactGroupFinder;
import javax.persistence.Entity;

@Entity
public class ContactGroup extends BasicDomain {

  public static final ContactGroupFinder find = new ContactGroupFinder();

  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
