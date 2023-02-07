package com.codurance.shoppingcart;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
  Printer printer;
  List<Product> productList = new ArrayList<>();

  public ShoppingCart(Printer printer) {
    this.printer = printer;
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

    String products = getProducts() +
      separatorWithPipe;

    String promotionCode = "| Promotion:                               |\n" +
      separator + "\n";

    String total = "| Total products: 0                        |\n" +
      "| Total price:  0.00 €                     |\n" +
      separator;

    return header + products + promotionCode + total;
  }

  private String getProducts() {
    String products = "";

    for (Product product : productList) {
      products += String.format("| %-11s  | %-14s | %-8s |\n",
        product.name(), formatFinalPrice(product), 1);
    }

    return products;
  }

  private String formatFinalPrice(Product product) {
    return product.finalCost() + " €";
  }

  public void addItem(Product product) {
    productList.add(product);
  }
}
