package com.codurance.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
  private List<Product> products = new ArrayList<>();
  public void addItem(Product product) {
    products.add(product);
  }
  public List<Product> getProducts() {
    return products;
  }
}
