package com.codurance.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
  List<Product> shoppingList = new ArrayList<>();

  public void add(Product product) {
    shoppingList.add(product);
  }

  public int byProductName(String some_product) {
    return Math.toIntExact(shoppingList.stream()
      .filter(product -> some_product.equals(product.name()))
      .count());
  }
}
