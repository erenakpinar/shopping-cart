package com.trendyol.app.discount.applier;

import com.trendyol.app.discount.entity.Coupon;
import com.trendyol.app.discount.type.DiscountType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CouponDiscountApplierTest extends BaseDiscountApplierTest {
    Coupon coupon = new Coupon(100, 10, DiscountType.AMOUNT);

    @Test
    void test_Apply_ShouldBe_Zero_IfTotalAmountAfterDiscountsLessThanCouponMinimumAmount() {
        Mockito.doReturn(90.0).when(cart).getTotalAmountAfterDiscounts();
        Mockito.doReturn(coupon).when(cart).getCoupon();

        assertEquals(0, couponDiscountApplier.apply(cart));
    }

    @Test
    void test_Apply_ShouldBe_CouponDiscount_IfGivenAmountTypeCoupon() {
        Mockito.doReturn(coupon).when(cart).getCoupon();

        assertEquals(10, couponDiscountApplier.apply(cart));
    }
}