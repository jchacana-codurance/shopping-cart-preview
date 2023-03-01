package com.codurance.shoppingcart.feature;

import com.codurance.shoppingcart.CartRepository;
import com.codurance.shoppingcart.Printer;
import com.codurance.shoppingcart.Product;
import com.codurance.shoppingcart.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.util.Map;
import static org.mockito.Mockito.spy;
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
    "| Total products: 8                        |\n" +
    "| Total price: 11.71 €                     |\n" +
    "--------------------------------------------";

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

  private static final String SHOPPING_CART_WITH_PRODUCTS =
    "--------------------------------------------\n" +
      "| Product name | Price with VAT | Quantity |\n" +
      "| -----------  | -------------- | -------- |\n" +
      "| Iceberg      | 2.17 €         | 1        |\n" +
      "| Tomatoe      | 0.73 €         | 1        |\n" +
      "| Chicken      | 1.83 €         | 1        |\n" +
      "| Bread        | 0.88 €         | 1        |\n" +
      "| Corn         | 1.50 €         | 1        |\n" +
      "|------------------------------------------|\n" +
      "| Promotion:                               |\n" +
      "--------------------------------------------\n" +
      "| Total products: 5                        |\n" +
      "| Total price:  7.11 €                     |\n" +
      "--------------------------------------------";

  private Map<String, Product> PRODUCT_CATALOG = Map.of(
    "Iceberg", new Product("Iceberg", 1.55, 15, 1.79, 21, 2.17),
    "Tomato", new Product("Tomato", 0.52, 15, 0.60, 21, 0.73),
    "Chicken", new Product("Chicken", 1.34, 12, 1.51, 21, 1.83),
    "Bread", new Product("Bread", 0.71, 12, 0.80, 10, 0.88),
    "Corn", new Product("Corn", 1.21, 12, 1.36, 10, 1.50)
  );

  @Test
  public void SeeEmptyShoppingCart() {
    CartRepository repo = new CartRepository();
    TestablePrinter printer = spy(new TestablePrinter());
    ShoppingCart shoppingCart = new ShoppingCart(printer, repo);

    shoppingCart.printShoppingCart();

    verify(printer).print(EMPTY_SHOPPING_CART);
  }

  @Test
  public void SeeAShoppingCartWithProducts() {
    TestablePrinter printer = spy(new TestablePrinter());
    CartRepository repo = new CartRepository();
    ShoppingCart shoppingCart = new ShoppingCart(printer, repo);
    shoppingCart.addItem(PRODUCT_CATALOG.get("Iceberg"));
    shoppingCart.addItem(PRODUCT_CATALOG.get("Tomato"));
    shoppingCart.addItem(PRODUCT_CATALOG.get("Chicken"));
    shoppingCart.addItem(PRODUCT_CATALOG.get("Bread"));
    shoppingCart.addItem(PRODUCT_CATALOG.get("Corn"));

    shoppingCart.printShoppingCart();

    verify(printer).print(SHOPPING_CART_WITH_PRODUCTS);
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

class TestablePrinter extends Printer{

  @Override
  public String print(String input) {
    return super.print(input);
  }
}
