package com.codurance.shoppingcart;

public interface IShoppingCart {
  void printShoppingCart();

  void addItem(Product product);

  void applyDiscount(Discount discount);
}
