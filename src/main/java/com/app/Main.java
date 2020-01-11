package com.app;

import com.app.discount.type.DiscountType;
import com.app.manager.cart.CartManager;
import com.app.manager.cart.ICartManager;
import com.app.delivery.cost.DeliveryCostCalculator;
import com.app.discount.applier.CampaignDiscountApplier;
import com.app.discount.applier.CouponDiscountApplier;
import com.app.discount.calculator.DiscountCalculator;
import com.app.discount.calculator.IDiscountCalculator;
import com.app.discount.entity.Campaign;
import com.app.discount.entity.Coupon;
import com.app.entity.Cart;
import com.app.entity.Category;
import com.app.entity.Product;

public class Main {

    public static void main(String[] args) {
        Category electronic = new Category("Electronic");
        Category apple = new Category("Apple", electronic);
        Category samsung = new Category("Samsung");

        Product macBookPro = new Product("MacBook Pro", 10, apple);
        Product iPhone = new Product("iPhone", 15.99, apple);
        Product samsungWatch = new Product("Samsung Watch", 20, samsung);

        ICartManager cartManager = new CartManager();
        IDiscountCalculator discountCalculator = new DiscountCalculator();
        DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator(3, 3, Cart.DELIVERY_FIXED_COST);

        Cart cart = new Cart(
                cartManager,
                new CampaignDiscountApplier(cartManager, discountCalculator),
                new CouponDiscountApplier(discountCalculator),
                deliveryCostCalculator
        );

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
        Coupon coupon = new Coupon(100, 10, DiscountType.AMOUNT);

        cart.applyDiscounts(campaign1, campaign2, campaign3);
        cart.applyCoupon(coupon);

        cart.print();
    }
}
