package com.codurance.shoppingcart.unitTests;

import com.codurance.shoppingcart.CartRepository;
import com.codurance.shoppingcart.Printer;
import com.codurance.shoppingcart.Product;
import com.codurance.shoppingcart.ShoppingCart;
import org.junit.jupiter.api.Disabled;
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

  @Disabled
  @Test
  void print_empty_cart() {
    Printer printer = Mockito.mock(Printer.class);
    CartRepository cartRepository = Mockito.mock(CartRepository.class);
    ShoppingCart shoppingCart = new ShoppingCart(cartRepository, printer);

    shoppingCart.printShoppingCart();

    Mockito.verify(printer).print(EMPTY_CART);

  }

  @Test
  void addAnItemToTheCurrentCart() {
    Printer printer = Mockito.mock(Printer.class);
    CartRepository cartRepository = Mockito.mock(CartRepository.class);
    ShoppingCart shoppingCart = new ShoppingCart(cartRepository, printer);

    Product product = new Product("Some Product", 1.00, 1, 1.79, 10, 2.17);
    shoppingCart.addItem(product);

    Mockito.verify(cartRepository).addItem(product);
  }
}
