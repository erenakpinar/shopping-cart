package com.trendyol.app.delivery.cost;

import com.trendyol.app.entity.Cart;
import com.trendyol.app.entity.CartItem;

import java.util.List;

public interface IDeliveryCostCalculator {
    double calculateFor(Cart cart);
    int getNumberOfDeliveries(List<CartItem> cartItemList);
}
