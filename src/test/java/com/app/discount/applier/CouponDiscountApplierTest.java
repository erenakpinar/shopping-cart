package com.app.discount.applier;

import com.app.discount.entity.Coupon;
import com.app.discount.type.DiscountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CouponDiscountApplierTest extends BaseDiscountApplierTest {
    Coupon coupon = new Coupon(100, 10, DiscountType.AMOUNT);

    @Test
    void test_Apply_ShouldBe_Zero_IfTotalAmountAfterDiscountsLessThanCouponMinimumAmount() {
        Mockito.doReturn(90.0).when(cart).getTotalAmountAfterDiscounts();
        Mockito.doReturn(coupon).when(cart).getCoupon();

        Assertions.assertEquals(0, couponDiscountApplier.apply(cart));
    }

    @Test
    void test_Apply_ShouldBe_CouponDiscount_IfGivenAmountTypeCoupon() {
        Mockito.doReturn(coupon).when(cart).getCoupon();

        Assertions.assertEquals(10, couponDiscountApplier.apply(cart));
    }
}