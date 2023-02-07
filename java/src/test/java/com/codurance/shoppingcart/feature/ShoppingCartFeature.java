package com.codurance.shoppingcart.feature;

import com.codurance.shoppingcart.Printer;
import com.codurance.shoppingcart.ShoppingCart;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ShoppingCartFeature {

  private static final String SHOPPING_CART_WITH_PRODUCTS_AND_PROMOCODE =
    "--------------------------------------------\n" +
    "| Product name | Price with VAT | Quantity |\n" +
    "| -----------  | -------------- | -------- |\n" +
    "| Iceberg      | 2.17 €         | 3        |\n" +
      "| Tomatoe      | 0.73 €         | 1        |\n" +
      "| Chicken      | 1.83 €         | 1        |\n" +
      "| Bread        | 0.88 €         | 2        |\n" +
      "| Corn         | 1.50 €         | 1        |\n" +
      "|------------------------------------------|\n" +
      "| Promotion: 5% off with code PROMO_5      |\n" +
      "--------------------------------------------\n" +
      "| Total productos: 8                       |\n" +
      "| Total price: 11.71 €                     |\n" +
      "--------------------------------------------";

  private static final String EMPTY_SHOPPING_CART =
    "--------------------------------------------\n" +
      "| Product name | Price with VAT | Quantity |\n" +
      "| -----------  | -------------- | -------- |\n" +
      "|------------------------------------------|\n" +
      "| Promotion:                               |\n" +
      "--------------------------------------------\n" +
      "| Total productos: 0                       |\n" +
      "| Total price:  0.00 €                     |\n" +
      "--------------------------------------------";
//  private List<Product> PRODUCT_CATALOG = List.of(
//    new Product("Iceberg", 1.55, 15, 1.79, 21, 2.17),
//    new Product("Tomato", 0.52, 15, 0.60, 21, 0.73),
//    new Product("Chicken", 1.34, 12, 1.51, 21, 1.83),
//    new Product("Bread", 0.71, 12, 0.80, 10, 0.88),
//    new Product("Corn", 1.21, 12, 1.36, 10, 1.50)
//  );

  @Test
  public void SeeEmptyShoppingCart() {
    Printer printer = mock(Printer.class);
    ShoppingCart shoppingCart = new ShoppingCart(printer);

    shoppingCart.printShoppingCart();

    verify(printer).print(EMPTY_SHOPPING_CART);
  }

 /* @Test
	public void SeeAShoppingCartWithDiscountsApplied() { //Use case
    Printer printer = mock(Printer.class);
    CartRepository cartRepository = new CartRepository();
    ShoppingCart shoppingCart = new ShoppingCart(cartRepository, printer);

    ProductRepository productRepository = new ProductRepository(PRODUCT_CATALOG);
    shoppingCart.addItem(productRepository.getProductByName("Iceberg"));
    shoppingCart.addItem(productRepository.getProductByName("Iceberg"));
    shoppingCart.addItem(productRepository.getProductByName("Iceberg"));
    shoppingCart.addItem(productRepository.getProductByName("Tomato"));
    shoppingCart.addItem(productRepository.getProductByName("Chicken"));
    shoppingCart.addItem(productRepository.getProductByName("Bread"));
    shoppingCart.addItem(productRepository.getProductByName("Bread"));
    shoppingCart.addItem(productRepository.getProductByName("Corn"));

    shoppingCart.applyDiscount(PROMO_5);

    shoppingCart.printShoppingCart();

    verify(printer).print(SHOPPING_CART_WITH_PRODUCTS_AND_PROMOCODE);
	}*/
}
