package com.codurance.shoppingcart;

import java.util.List;

public class ProductRepository {
  private List<Product> products;

  public ProductRepository(List<Product> products) {
    this.products = products;
  }

  public Product getProductByName(String name) {
    return products.stream()
      .filter(product -> product.name().equals(name))
      .findFirst().orElseThrow(() -> new NotFoundException("Product not found: " + name));
  }
}
