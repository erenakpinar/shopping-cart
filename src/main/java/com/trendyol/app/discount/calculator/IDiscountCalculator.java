package com.trendyol.app.discount.calculator;

import com.trendyol.app.discount.type.DiscountType;

public interface IDiscountCalculator {
    double calculate(double totalPrice, double discount, DiscountType discountType);
}
