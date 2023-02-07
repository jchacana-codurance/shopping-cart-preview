package com.codurance.shoppingcart.unit;

import com.codurance.shoppingcart.Printer;
import com.codurance.shoppingcart.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ShoppingCartShould {

  private static final String EMPTY_SHOPPING_CART =
    "--------------------------------------------\n" +
      "| Product name | Price with VAT | Quantity |\n" +
      "| -----------  | -------------- | -------- |\n" +
      "|------------------------------------------|\n" +
      "| Promotion:                               |\n" +
      "--------------------------------------------\n" +
      "| Total products: 0                        |\n" +
      "| Total price:  0.00 €                     |\n" +
      "--------------------------------------------";

  @Test
  void printEmptyCart() {
    Printer printer = mock(Printer.class);
    ShoppingCart shoppingCart = new ShoppingCart(printer);

    shoppingCart.printShoppingCart();

    verify(printer).print(EMPTY_SHOPPING_CART);
  }
}
