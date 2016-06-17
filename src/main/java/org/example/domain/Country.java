package org.example.domain;

import com.avaje.ebean.annotation.Cache;
import com.avaje.ebean.annotation.DocSortable;
import com.avaje.ebean.annotation.DocStore;
import org.example.domain.finder.CountryFinder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Country entity bean.
 */
@DocStore
@Cache
@Entity
@Table(name = "o_country")
public class Country {

  public static final CountryFinder find = new CountryFinder();

  @Id
  @Size(max = 2)
  String code;

  @DocSortable
  @Size(max = 60)
  String name;

  public String toString() {
    return code + ": " + name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
