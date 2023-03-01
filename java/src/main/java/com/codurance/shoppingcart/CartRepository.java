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

  public Integer getNumberOfProducts() {
    return products.size();
  }

  public Double getFinalCost() {
    return products.stream().map(Product::finalCost).reduce(0.0, (Double::sum));
  }
}
