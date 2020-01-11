package com.app.discount.calculator.type;

public class DiscountAmountCalculator implements IDiscountTypeCalculator {
    @Override
    public double calculate(double totalPrice, double discount) {
        return Math.min(discount, totalPrice);
    }
}
