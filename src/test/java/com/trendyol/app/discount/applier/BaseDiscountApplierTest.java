package com.trendyol.app.discount.applier;

import com.trendyol.app.discount.calculator.DiscountCalculator;
import com.trendyol.app.discount.calculator.IDiscountCalculator;
import com.trendyol.app.discount.entity.Campaign;
import com.trendyol.app.discount.type.DiscountType;
import com.trendyol.app.entity.Cart;
import com.trendyol.app.entity.Category;
import com.trendyol.app.entity.Product;
import com.trendyol.app.manager.cart.CartManager;
import com.trendyol.app.manager.cart.ICartManager;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class BaseDiscountApplierTest {
    Category electronic = new Category("Electronic");
    Category apple = new Category("Apple", electronic);
    Category samsung = new Category("Samsung");

    Product macBookPro = new Product("MacBook Pro", 10, apple);
    Product iPhone = new Product("iPhone", 15.99, apple);
    Product samsungWatch = new Product("Samsung Watch", 20, samsung);

    Campaign campaign1 = new Campaign(electronic, 20, 2, DiscountType.RATE);
    Campaign campaign2 = new Campaign(apple, 50, 2, DiscountType.AMOUNT);
    Campaign campaign3 = new Campaign(samsung, 60, 5, DiscountType.AMOUNT);

    ICartManager cartManager = Mockito.spy(new CartManager());
    Cart cart;
    IDiscountCalculator discountCalculator = Mockito.spy(new DiscountCalculator());
    IDiscountApplier campaignDiscountApplier = new CampaignDiscountApplier(cartManager, discountCalculator);
    IDiscountApplier mockCampaignDiscountApplier = Mockito.spy(campaignDiscountApplier);
    IDiscountApplier couponDiscountApplier = new CouponDiscountApplier(discountCalculator);
    IDiscountApplier mockCouponDiscountApplier = Mockito.spy(couponDiscountApplier);

    @BeforeEach
    void setUp() {
        cart = Mockito.spy(new Cart(cartManager, mockCampaignDiscountApplier, mockCouponDiscountApplier));
        cart.addItem(macBookPro, 1);
        cart.addItem(macBookPro, 3);
        cart.addItem(iPhone, 1);
        cart.addItem(iPhone, 2);
        cart.addItem(iPhone, 1);
        cart.addItem(samsungWatch, 3);
        cart.addItem(samsungWatch, 1);
    }
}
