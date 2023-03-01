package com.codurance.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
  Printer printer;
  private CartRepository repo;
  List<Product> productList = new ArrayList<>();

  public ShoppingCart(Printer printer, CartRepository repo) {
    this.printer = printer;
    this.repo = repo;
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
      "| Total price:  %s €                     |\n" +
      separator, productList.size(), getFinalPrice());

    return header + products + promotionCode + total;
  }

  private String getFinalPrice() {
    return productList.size() > 0? ""+ productList.get(0).finalCost(): "0.00";
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
    repo.addItem(product);
  }
}
