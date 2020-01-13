package com.app.discount.entity;

import com.app.discount.type.DiscountType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CouponTest {

    @Test
    void test_GetMinimumAmount_ShouldBe_Equals_GivenAmount() {
        Coupon coupon = new Coupon(100, 10, DiscountType.RATE);

        assertEquals(100, coupon.getMinimumAmount());
    }
}