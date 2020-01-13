package com.app.discount.calculator;

import com.app.discount.type.DiscountType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountCalculatorTest {
    DiscountCalculator discountCalculator = new DiscountCalculator();

    @Test
    void test_Calculate_ShouldBe_PercentAmount_IfDiscountTypeIsRate() {
        assertEquals(110, discountCalculator.calculate(1000, 11, DiscountType.RATE));
    }

    @Test
    void test_Calculate_ShouldBe_SameAsAmountGiven_IfDiscountTypeIsAmount() {
        assertEquals(110, discountCalculator.calculate(1000, 110, DiscountType.AMOUNT));
    }

    @Test
    void test_Calculate_ShouldBe_Zero_IfAmountLessThanZero() {
        assertEquals(100, discountCalculator.calculate(100, 110, DiscountType.AMOUNT));
    }
}