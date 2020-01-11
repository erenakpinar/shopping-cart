package com.trendyol.app.discount.applier;

import com.trendyol.app.discount.calculator.IDiscountCalculator;
import com.trendyol.app.entity.Cart;

public class CouponDiscountApplier implements IDiscountApplier {

    private IDiscountCalculator discountCalculator;

    public CouponDiscountApplier(IDiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }
    @Override
    public double apply(Cart cart) {
        if (cart.getTotalAmountAfterDiscounts() >= cart.getCoupon().getMinimumAmount()) {
            return discountCalculator.calculate(
                    cart.getTotalAmountAfterDiscounts(),
                    cart.getCoupon().getDiscount(),
                    cart.getCoupon().getDiscountType()
            );
        }

        return 0;
    }
}
