package com.codurance.shoppingcart.unitTests;

import com.codurance.shoppingcart.CartRepository;
import com.codurance.shoppingcart.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartRepositoryShould {

  public static final Product SOME_PRODUCT = new Product("Some Product", 1.00, 1, 1.79, 10, 2.17);
  public static final Product OTHER_PRODUCT = new Product("Other Product", 2.00, 1, 1.79, 10, 3.17);
  private CartRepository cartRepository;

  @BeforeEach
  void setUp() {
    cartRepository = new CartRepository();
  }

  @Test
  void addItemToProductsList() {

    cartRepository.add(SOME_PRODUCT);

    assertEquals( 1, cartRepository.byProductName("Some Product"));
  }

  @Test
  void addMultipleSameItemsToProductList() {

    cartRepository.add(SOME_PRODUCT);
    cartRepository.add(SOME_PRODUCT);

    assertEquals( 2, cartRepository.byProductName("Some Product"));
  }

  @Test
  void addMultipleDifferentItemsToProductList() {

    cartRepository.add(SOME_PRODUCT);
    cartRepository.add(OTHER_PRODUCT);

    assertEquals( 1, cartRepository.byProductName("Some Product"));
  }
}
