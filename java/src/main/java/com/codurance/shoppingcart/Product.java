package com.codurance.shoppingcart;

public record Product(String name, double cost, int revenuePercentage, double pricePerUnit, int taxPercentage,
                      double finalCost) {
}
