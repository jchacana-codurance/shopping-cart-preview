package com.codurance.shoppingcart.unitTests;

import com.codurance.shoppingcart.CartRepository;
import com.codurance.shoppingcart.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CartRepositoryShould {

  @Test
  void addItemToProductsList() {
    CartRepository cartRepository = new CartRepository();

    Product product = new Product("Some Product", 1.00, 1, 1.79, 10, 2.17);
    cartRepository.add(product);

    Assertions.assertEquals( 1, cartRepository.byProductName("Some Product"));
  }

  @Disabled
  @Test
  void addMultipleSameItemsToProductList() {
    CartRepository cartRepository = new CartRepository();

    Product product = new Product("Some Product", 1.00, 1, 1.79, 10, 2.17);
    cartRepository.add(product);
    cartRepository.add(product);

    Assertions.assertEquals( 2, cartRepository.byProductName("Some Product"));
  }
}
