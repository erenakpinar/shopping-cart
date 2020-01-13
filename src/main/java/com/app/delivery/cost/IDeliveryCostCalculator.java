package com.app.delivery.cost;

import com.app.entity.Cart;
import com.app.entity.CartItem;

import java.util.List;

public interface IDeliveryCostCalculator {
    double calculateFor(Cart cart);

    int getNumberOfDeliveries(List<CartItem> cartItemList);
}
