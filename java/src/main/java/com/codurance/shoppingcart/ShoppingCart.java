package com.codurance.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
  Printer printer;
  private CartRepository repository;

  public ShoppingCart(Printer printer, CartRepository repository) {
    this.printer = printer;
    this.repository = repository;
  }

  public void printShoppingCart() {
    String textToPrint = formatTicket();

    printer.print(textToPrint);
  }

  private String formatTicket() {
    String separatorWithPipe = "|------------------------------------------|\n";
    String separator = "--------------------------------------------";

    String header = separator + "\n" +
      "| Product name | Price with VAT | Quantity |\n" +
      "| -----------  | -------------- | -------- |\n";

    String products = getProducts() + separatorWithPipe;

    String promotionCode = "| Promotion:                               |\n" +
      separator + "\n";

    String total = String.format("| Total products: %-25s|\n" +
      "| Total price:  %-27s|\n" +
      separator, repository.getProducts().size(), getFinalPrice());

    return header + products + promotionCode + total;
  }

  private String getFinalPrice() {
    return repository.getProducts().size() > 0? ""+ repository.getProducts().get(0).finalCost() + " €": "0.00 €";
  }

  private String getProducts() {
    String products = "";

    for (Product product : repository.getProducts()) {
      products += String.format("| %-11s  | %-14s | %-8s |\n",
        product.name(), formatFinalPrice(product), 1);
    }

    return products;
  }

  private String formatFinalPrice(Product product) {
    return product.finalCost() + " €";
  }

  public void addItem(Product product) {
    repository.addItem(product);
  }
}
