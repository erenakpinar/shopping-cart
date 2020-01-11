package com.trendyol.app.discount.entity;

import com.trendyol.app.discount.type.DiscountType;

public class Coupon extends Discount {
    private double minimumAmount;

    public Coupon(double minimumAmount, double discount, DiscountType discountType) {
        super(discountType, discount);
        this.minimumAmount = minimumAmount;
    }

    public double getMinimumAmount() {
        return minimumAmount;
    }
}
