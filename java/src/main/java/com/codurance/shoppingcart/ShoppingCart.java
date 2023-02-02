package com.codurance.shoppingcart;

public class ShoppingCart implements IShoppingCart {
  private Printer printer;

  public ShoppingCart(CartRepository cartRepository, Printer printer) {
    this.printer = printer;
  }

  @Override
  public void printShoppingCart() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addItem(Product product) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void applyDiscount(Discount discount) {
    throw new UnsupportedOperationException();
  }
}
