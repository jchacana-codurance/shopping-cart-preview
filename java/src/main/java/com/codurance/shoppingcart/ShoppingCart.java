package com.codurance.shoppingcart;

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

    Integer numberOfProducts = repository.getNumberOfProducts();
    String total = String.format("| Total products: %-25s|\n" +
      "| Total price:  %-27s|\n" +
      separator, numberOfProducts, getFinalPrice(numberOfProducts));

    return header + products + promotionCode + total;
  }

  private String getFinalPrice(Integer numberOfProducts) {
    Double finalCost = repository.getFinalCost();

    return numberOfProducts > 0? ""+ String.format("%.2f", finalCost) + " €": "0.00 €";
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
    return String.format("%.2f", product.finalCost()) + " €";
  }

  public void addItem(Product product) {
    repository.addItem(product);
  }
}
