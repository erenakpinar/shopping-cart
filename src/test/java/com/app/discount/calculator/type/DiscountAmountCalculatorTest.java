package com.app.discount.calculator.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountAmountCalculatorTest {
    DiscountAmountCalculator discountAmountCalculator = new DiscountAmountCalculator();

    @Test
    void test_Calculate_Should_ReturnDiscountedAmount() {
        assertEquals(10, discountAmountCalculator.calculate(1000, 10));
    }
}