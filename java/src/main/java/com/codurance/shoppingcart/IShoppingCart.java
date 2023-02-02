package com.codurance.shoppingcart;

import com.codurance.shoppingcart.feature.Discount;

public interface IShoppingCart {
  void printShoppingCart();

  void addItem(Product product);

  void applyDiscount(Discount discount);
}
