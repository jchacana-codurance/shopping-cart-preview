package com.codurance.shoppingcart;

public class ShoppingCart {
  Printer printer;

  public ShoppingCart(Printer printer) {
    this.printer = printer;
  }

  public void printShoppingCart() {
    String textToPrint =
      "--------------------------------------------\n" +
        "| Product name | Price with VAT | Quantity |\n" +
        "| -----------  | -------------- | -------- |\n" +
        "|------------------------------------------|\n" +
        "| Promotion:                               |\n" +
        "--------------------------------------------\n" +
        "| Total products: 0                        |\n" +
        "| Total price:  0.00 €                     |\n" +
        "--------------------------------------------";

    printer.print(textToPrint);
  }
}
