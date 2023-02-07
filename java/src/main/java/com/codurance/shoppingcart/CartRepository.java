package com.codurance.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
  List<Product> shoppingList = new ArrayList<>();

  public void add(Product product) {
    shoppingList.add(product);
  }

  public Long byProductName(String productName) {
    return shoppingList.stream()
      .filter(product -> productName.equals(product.name()))
      .count();
  }
}
