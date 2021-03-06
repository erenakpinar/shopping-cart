package com.app.discount.entity;

import com.app.discount.type.DiscountType;
import com.app.entity.Category;

public class Campaign extends Discount {
    private Category category;
    private int itemCount;

    public Campaign(Category category, double discount, int itemCount, DiscountType discountType) {
        super(discountType, discount);
        this.category = category;
        this.itemCount = itemCount;
    }

    public Category getCategory() {
        return category;
    }

    public int getItemCount() {
        return itemCount;
    }
}
