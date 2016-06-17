package org.example.domain;

import com.avaje.ebean.annotation.DocProperty;
import org.example.domain.finder.ProductFinder;
import com.avaje.ebean.annotation.DocCode;
import com.avaje.ebean.annotation.DocSortable;
import com.avaje.ebean.annotation.DocStore;
import org.example.domain.query.QProduct;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Product entity bean.
 */
@DocStore
@Entity
@Table(name = "o_product")
public class Product extends BasicDomain {

  public static final ProductFinder find = new ProductFinder();

  @DocCode
  @Size(max = 20)
  String sku;

  @DocSortable
  String name;

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
