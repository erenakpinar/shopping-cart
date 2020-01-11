package com.app.discount.calculator;

import com.app.discount.type.DiscountType;

public interface IDiscountCalculator {
    double calculate(double totalPrice, double discount, DiscountType discountType);
}
