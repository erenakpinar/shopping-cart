package com.trendyol.app.discount.applier;

import com.trendyol.app.entity.Cart;

public interface IDiscountApplier {
    double apply(Cart cart);
}
