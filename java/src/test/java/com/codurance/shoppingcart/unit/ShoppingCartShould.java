package com.codurance.shoppingcart.unit;

import com.codurance.shoppingcart.Printer;
import com.codurance.shoppingcart.Product;
import com.codurance.shoppingcart.ShoppingCart;
import org.junit.jupiter.api.Disabled;
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

  private static final String SHOPPING_CART_WITH_PRODUCT =
    "--------------------------------------------\n" +
      "| Product name | Price with VAT | Quantity |\n" +
      "| -----------  | -------------- | -------- |\n" +
      "| Iceberg      | 2.17 €         | 1        |\n" +
      "|------------------------------------------|\n" +
      "| Promotion:                               |\n" +
      "--------------------------------------------\n" +
      "| Total products: 1                        |\n" +
      "| Total price:  2.17 €                     |\n" +
      "--------------------------------------------";

  @Test
  void printEmptyCart() {
    Printer printer = mock(Printer.class);
    ShoppingCart shoppingCart = new ShoppingCart(printer);

    shoppingCart.printShoppingCart();

    verify(printer).print(EMPTY_SHOPPING_CART);
  }

  @Disabled
  @Test
  void printCartWithOneItem() {
    Printer printer = mock(Printer.class);
    ShoppingCart shoppingCart = new ShoppingCart(printer);
    Product iceberg = new Product("Iceberg", 1.55, 15, 1.79, 21, 2.17);
    shoppingCart.addItem(iceberg);

    shoppingCart.printShoppingCart();

    verify(printer).print(SHOPPING_CART_WITH_PRODUCT);
  }
}
