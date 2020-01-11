package com.app.discount.calculator.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountAmountCalculatorTest {
    DiscountAmountCalculator discountAmountCalculator = new DiscountAmountCalculator();
    @Test
    void test_Calculate() {
        assertEquals(10, discountAmountCalculator.calculate(1000, 10));
    }
}