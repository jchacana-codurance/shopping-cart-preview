package com.codurance.shoppingcart;

public class ShoppingCart implements IShoppingCart {
  private Printer printer;
  private CartRepository cartRepository;

  public ShoppingCart(CartRepository cartRepository, Printer printer) {
    this.cartRepository = cartRepository;
    this.printer = printer;
  }

  @Override
  public void printShoppingCart() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addItem(Product product) {
    cartRepository.addItem(product);
  }

  @Override
  public void applyDiscount(Discount discount) {
    throw new UnsupportedOperationException();
  }
}
