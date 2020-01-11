package com.trendyol.app.discount.entity;

import com.trendyol.app.discount.type.DiscountType;

public class Coupon {
    private double minimumAmount;
    private double discount;
    private DiscountType discountType;

    public Coupon(double minimumAmount, double discount, DiscountType discountType) {
        this.minimumAmount = minimumAmount;
        this.discount = discount;
        this.discountType = discountType;
    }
}
