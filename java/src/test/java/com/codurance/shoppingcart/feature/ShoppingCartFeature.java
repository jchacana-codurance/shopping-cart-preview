package com.codurance.shoppingcart.feature;

import com.codurance.shoppingcart.Printer;
import com.codurance.shoppingcart.ProductRepository;
import com.codurance.shoppingcart.ShoppingCart;
import org.junit.jupiter.api.Test;

import static com.codurance.shoppingcart.Discount.PROMO_5;
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

  @Test
	public void SeeAShoppingCartWithDiscountsApplied() { //Use case
    Printer printer = mock(Printer.class);

    ShoppingCart shoppingCart = new ShoppingCart(printer);

    ProductRepository productRepository = new ProductRepository();
    shoppingCart.addItem(productRepository.getProductByName("Iceberg"));
    shoppingCart.addItem(productRepository.getProductByName("Iceberg"));
    shoppingCart.addItem(productRepository.getProductByName("Iceberg"));
    shoppingCart.addItem(productRepository.getProductByName("Tomatoe"));
    shoppingCart.addItem(productRepository.getProductByName("Chicken"));
    shoppingCart.addItem(productRepository.getProductByName("Bread"));
    shoppingCart.addItem(productRepository.getProductByName("Bread"));
    shoppingCart.addItem(productRepository.getProductByName("Corn"));

    shoppingCart.applyDiscount(PROMO_5);

    shoppingCart.printShoppingCart();

    verify(printer).print(SHOPPING_CART_WITH_PRODUCTS_AND_PROMOCODE);
	}
}
