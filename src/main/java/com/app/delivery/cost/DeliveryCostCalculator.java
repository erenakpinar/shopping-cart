package com.trendyol.app.delivery.cost;

import com.trendyol.app.entity.Cart;
import com.trendyol.app.entity.CartItem;
import com.trendyol.app.entity.Category;

import java.util.HashSet;
import java.util.List;

public class DeliveryCostCalculator implements IDeliveryCostCalculator {

    private double costPerDelivery;
    private double costPerProduct;
    private double fixedCost;

    public DeliveryCostCalculator(double costPerDelivery, double costPerProduct, double fixedCost) {
        this.costPerDelivery = costPerDelivery;
        this.costPerProduct = costPerProduct;
        this.fixedCost = fixedCost;
    }

    @Override
    public double calculateFor(Cart cart) {
        int numberOfProducts = cart.getItems().size();
        int numberOfDeliveries = getNumberOfDeliveries(cart.getItems());

        return (costPerDelivery * numberOfDeliveries)
                + (costPerProduct * numberOfProducts)
                + fixedCost;
    }

    public int getNumberOfDeliveries(List<CartItem> cartItems) {
        HashSet<Category> categoryHashSet = new HashSet<>();
        cartItems.forEach(cartItem -> {
            categoryHashSet.add(cartItem.getProduct().getCategory());
        });

        return categoryHashSet.size();
    }
}
