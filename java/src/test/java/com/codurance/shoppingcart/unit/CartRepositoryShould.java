package com.codurance.shoppingcart.unit;

import com.codurance.shoppingcart.CartRepository;
import com.codurance.shoppingcart.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CartRepositoryShould {

  @Test
  void AddItemToInMemoryData() {
    Product iceberg = new Product("Iceberg", 1.55, 15, 1.79, 21, 2.17);
    CartRepository repository = new CartRepository();

    repository.addItem(iceberg);

    Assertions.assertEquals(Arrays.asList(iceberg), repository.getProducts());
  }
}
