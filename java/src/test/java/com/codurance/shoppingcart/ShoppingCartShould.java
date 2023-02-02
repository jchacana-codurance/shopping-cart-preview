package com.codurance.shoppingcart;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ShoppingCartShould {

  private static final String EMPTY_CART =
    "--------------------------------------------\n" +
    "| Product name | Price with VAT | Quantity |\n" +
    "| -----------  | -------------- | -------- |\n" +
    "|------------------------------------------|\n" +
    "| Promotion:                               |\n" +
    "--------------------------------------------\n" +
    "| Total productos: 0                       |\n" +
    "| Total price: 0.00 €                      |\n" +
    "--------------------------------------------";

  @Test
  void print_empty_cart() {
    Printer printer = Mockito.mock(Printer.class);
    ShoppingCart shoppingCart = new ShoppingCart(printer);

    shoppingCart.printShoppingCart();

    Mockito.verify(printer).print(EMPTY_CART);

  }
}
