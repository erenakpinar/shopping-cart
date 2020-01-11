package com.app.discount.entity;

import com.app.discount.type.DiscountType;

public class Discount {
    protected DiscountType discountType;
    protected double discount;

    public Discount(DiscountType discountType, double discount) {
        this.discountType = discountType;
        this.discount = discount;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public double getDiscount() {
        return discount;
    }
}
