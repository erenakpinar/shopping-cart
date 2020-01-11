package com.trendyol.app.discount.entity;

import com.trendyol.app.discount.type.DiscountType;
import com.trendyol.app.entity.Category;

public class Campaign {
    private Category category;
    private double discount;
    private int itemCount;
    private DiscountType discountType;

    public Campaign(Category category, double discount, int itemCount, DiscountType discountType) {
        this.category = category;
        this.discount = discount;
        this.itemCount = itemCount;
        this.discountType = discountType;
    }
}
