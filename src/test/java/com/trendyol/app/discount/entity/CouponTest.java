package com.trendyol.app.discount.entity;

import com.trendyol.app.discount.type.DiscountType;
import com.trendyol.app.entity.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    @Test
    void test_GetMinimumAmount_ShouldBe_Equals_GivenAmount() {
        Coupon coupon = new Coupon(100, 10, DiscountType.RATE);

        assertEquals(100, coupon.getMinimumAmount());
    }
}