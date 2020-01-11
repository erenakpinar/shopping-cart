package com.trendyol.app.entity;

import com.trendyol.app.discount.entity.Campaign;
import com.trendyol.app.discount.entity.Coupon;
import com.trendyol.app.manager.cart.ICartManager;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private ICartManager cartManager;

    public Cart(ICartManager cartManager) {

        this.cartManager = cartManager;
    }

    private List<CartItem> cartItems = new ArrayList<CartItem>();
    private double totalAmount;
    private double totalAmountAfterDiscounts;

    private List<Campaign> campaigns = new ArrayList<Campaign>();
    private double campaignDiscount;

    private Coupon coupon;
    private double couponDiscount;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addItem(Product product, int quantity) {
        cartItems = this.cartManager.addItem(cartItems, product, quantity);
    }

    public void print() {
        cartItems.forEach(cartItem -> {
            System.out.println(cartItem.getProduct().getTitle() + " - " + cartItem.getQuantity());
        });
        System.out.println("---------");
    }

}
