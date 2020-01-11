package com.app.discount.applier;

import com.app.entity.Cart;

public interface IDiscountApplier {
    double apply(Cart cart);
}
