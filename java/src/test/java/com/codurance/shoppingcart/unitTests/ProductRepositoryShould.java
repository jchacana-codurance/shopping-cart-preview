package com.codurance.shoppingcart.unitTests;

import com.codurance.shoppingcart.Product;
import com.codurance.shoppingcart.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryShould {
  @Test
  void returnProductByName() {

    List<Product> products = new ArrayList<>();
    Product icebergLettuce = new Product("Iceberg", 1.55, 15, 1.79, 21, 2.17);
    products.add(icebergLettuce);
    ProductRepository productRepository = new ProductRepository(products);

    Product result = productRepository.getProductByName("Iceberg");

    Assertions.assertEquals(icebergLettuce, result);
  }
}
