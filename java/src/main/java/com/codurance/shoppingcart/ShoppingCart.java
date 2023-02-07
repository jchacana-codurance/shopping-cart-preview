package com.codurance.shoppingcart;

import java.text.MessageFormat;

public class ShoppingCart {
  Printer printer;

  public ShoppingCart(Printer printer) {
    this.printer = printer;
  }

  public void printShoppingCart() {
    String textToPrint = formatTicket();

    printer.print(textToPrint);
  }

  private static String formatTicket() {
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

  private static String getProducts() {
//    return MessageFormat.format("| {productName}  | {productPriceWithVAT} € | {productQuantity} |\n",
//      productName, productPriceWithVAT, productQuantity);
    return "";
  }

  public void addItem(Product product) {
    throw new UnsupportedOperationException();
  }
}
