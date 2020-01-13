package com.app.discount.calculator;

import com.app.discount.calculator.type.DiscountAmountCalculator;
import com.app.discount.calculator.type.DiscountRateCalculator;
import com.app.discount.calculator.type.IDiscountTypeCalculator;
import com.app.discount.type.DiscountType;

import java.util.HashMap;

public class DiscountCalculator implements IDiscountCalculator {

    private HashMap<DiscountType, IDiscountTypeCalculator> discountTypeHashMap = new HashMap<>();

    public DiscountCalculator() {
        discountTypeHashMap.put(DiscountType.RATE, new DiscountRateCalculator());
        discountTypeHashMap.put(DiscountType.AMOUNT, new DiscountAmountCalculator());
    }

    public double calculate(double totalPrice, double discount, DiscountType discountType) {
        IDiscountTypeCalculator discountCalculate = discountTypeHashMap.get(discountType);
        double calculatedDiscountAmount = discountCalculate.calculate(totalPrice, discount);

        return calculatedDiscountAmount >= 0 ? calculatedDiscountAmount : 0;
    }
}
