package com.codurance.shoppingcart;

import com.codurance.shoppingcart.feature.Discount;

public class ShoppingCart implements IShoppingCart {
  private Printer printer;

  public ShoppingCart(Printer printer) {
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
