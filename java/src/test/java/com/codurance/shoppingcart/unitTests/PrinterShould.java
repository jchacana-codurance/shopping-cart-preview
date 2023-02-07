package com.codurance.shoppingcart.unitTests;

import com.codurance.shoppingcart.Printer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrinterShould {

  @Test
  void returnInput() {
    String text = "text";
    Printer printer = new Printer();

    String result = printer.print(text);
    Assertions.assertEquals("text", result);
  }
}
