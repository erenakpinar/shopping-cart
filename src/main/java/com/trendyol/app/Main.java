package com.trendyol.app;

import com.trendyol.app.discount.entity.Campaign;
import com.trendyol.app.discount.entity.Coupon;
import com.trendyol.app.discount.type.DiscountType;
import com.trendyol.app.entity.Cart;
import com.trendyol.app.entity.Category;
import com.trendyol.app.entity.Product;
import com.trendyol.app.manager.cart.CartManager;
import com.trendyol.app.manager.cart.ICartManager;

public class Main {

    public static void main(String[] args) {
        Category electronic = new Category("Electronic");
        Category apple = new Category("Apple", electronic);
        Category samsung = new Category("Samsung");

        Product macBookPro = new Product("MacBook Pro", 10, apple);
        Product iPhone = new Product("iPhone", 15.99, apple);
        Product samsungWatch = new Product("Samsung Watch", 20, samsung);

        ICartManager cartManager = new CartManager();
        Cart cart = new Cart(cartManager);

        cart.addItem(macBookPro, 1);
        cart.addItem(macBookPro, 3);
        cart.addItem(iPhone, 1);
        cart.addItem(iPhone, 2);
        cart.addItem(iPhone, 1);
        cart.addItem(samsungWatch, 3);
        cart.addItem(samsungWatch, 1);

        Campaign campaign1 = new Campaign(electronic, 20, 2, DiscountType.RATE);
        Campaign campaign2 = new Campaign(apple, 50, 2, DiscountType.AMOUNT);
        Campaign campaign3 = new Campaign(samsung, 60, 5, DiscountType.AMOUNT);
        Coupon coupon1 = new Coupon(100, 10, DiscountType.AMOUNT);
    }
}