package com.trendyol.app.discount.calculator.type;

public class DiscountRateCalculator implements IDiscountTypeCalculator {
    @Override
    public double calculate(double totalPrice, double discount) {
        return totalPrice * (discount / 100);
    }
}
