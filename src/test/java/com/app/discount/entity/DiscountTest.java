package com.app.discount.entity;

import com.app.discount.type.DiscountType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountTest {

    @Test
    void test_GetDiscountType_ShouldBe_Equals_GivenRateDiscountType() {
        Discount discount = new Discount(DiscountType.RATE, 10);

        assertEquals(DiscountType.RATE, discount.getDiscountType());
    }

    @Test
    void test_GetDiscountType_ShouldBe_Equals_GivenAmountDiscountType() {
        Discount discount = new Discount(DiscountType.AMOUNT, 10);

        assertEquals(DiscountType.AMOUNT, discount.getDiscountType());
    }

    @Test
    void test_GetDiscount_ShouldBe_Equals_GivenDiscountAmount() {
        Discount discount = new Discount(DiscountType.RATE, 10);

        assertEquals(10, discount.getDiscount());
    }
}