package com.codurance.shoppingcart.unit;

import com.codurance.shoppingcart.CartRepository;
import com.codurance.shoppingcart.Printer;
import com.codurance.shoppingcart.Product;
import com.codurance.shoppingcart.ShoppingCart;
import org.assertj.core.error.ShouldBeOdd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShoppingCartShould {

  private ShoppingCart shoppingCart;
  private Printer printer;
  private CartRepository repo;
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

  private static final String SHOPPING_CART_WITH_ONE_PRODUCT =
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

  private static final String SHOPPING_CART_WITH_TWO_PRODUCTS =
    "--------------------------------------------\n" +
      "| Product name | Price with VAT | Quantity |\n" +
      "| -----------  | -------------- | -------- |\n" +
      "| Iceberg      | 2.17 €         | 1        |\n" +
      "| Tomatoe      | 0.73 €         | 1        |\n" +
      "|------------------------------------------|\n" +
      "| Promotion:                               |\n" +
      "--------------------------------------------\n" +
      "| Total products: 2                        |\n" +
      "| Total price:  2.90 €                     |\n" +
      "--------------------------------------------";

  @BeforeEach
  void setUp() {
    printer = mock(Printer.class);
    repo = mock(CartRepository.class);
    shoppingCart = new ShoppingCart(printer, repo);
  }

  @Test
  void printEmptyCart() {
    shoppingCart.printShoppingCart();

    verify(printer).print(EMPTY_SHOPPING_CART);
  }

  @Test
  void addItemToCart() {
    Product iceberg = new Product("Iceberg", 1.55, 15, 1.79, 21, 2.17);
    shoppingCart.addItem(iceberg);

    shoppingCart.printShoppingCart();

    verify(repo).addItem(iceberg);
  }

  @Test
  void printCartWithOneProduct() {
    Product iceberg = new Product("Iceberg", 1.55, 15, 1.79, 21, 2.17);
    Product tomatoe = new Product("Tomatoe", 0.52, 15, 0.60, 21, 0.73);

    List<Product> TWO_PRODUCT_LIST = Arrays.asList(iceberg, tomatoe);
    when(repo.getProducts()).thenReturn(TWO_PRODUCT_LIST);
    when(repo.getNumberOfProducts()).thenReturn(TWO_PRODUCT_LIST.size());
    when(repo.getFinalCost()).thenReturn(2.90);

    shoppingCart.addItem(iceberg);
    shoppingCart.addItem(tomatoe);
    shoppingCart.printShoppingCart();

    verify(printer).print(SHOPPING_CART_WITH_TWO_PRODUCTS);
  }

  @Test
  void printCartWithTwoProducts() {
    Product iceberg = new Product("Iceberg", 1.55, 15, 1.79, 21, 2.17);
    List<Product> ONE_PRODUCT_LIST = Arrays.asList(iceberg);
    when(repo.getProducts()).thenReturn(ONE_PRODUCT_LIST);
    when(repo.getNumberOfProducts()).thenReturn(ONE_PRODUCT_LIST.size());
    when(repo.getFinalCost()).thenReturn(ONE_PRODUCT_LIST.get(0).finalCost());

    shoppingCart.addItem(iceberg);
    shoppingCart.printShoppingCart();

    verify(printer).print(SHOPPING_CART_WITH_ONE_PRODUCT);
  }
}
