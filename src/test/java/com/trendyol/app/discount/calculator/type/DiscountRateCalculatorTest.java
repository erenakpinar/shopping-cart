package com.trendyol.app.discount.calculator.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountRateCalculatorTest {
    DiscountRateCalculator discountRateCalculator = new DiscountRateCalculator();
    @Test
    void test_Calculate() {
        assertEquals(100, discountRateCalculator.calculate(1000, 10));
    }
}