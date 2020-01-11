package com.app;

import com.app.discount.entity.Campaign;
import com.app.discount.type.DiscountType;
import com.app.manager.cart.CartManager;
import com.app.manager.cart.ICartManager;
import com.app.delivery.cost.DeliveryCostCalculator;
import com.app.discount.applier.CampaignDiscountApplier;
import com.app.discount.applier.CouponDiscountApplier;
import com.app.discount.applier.IDiscountApplier;
import com.app.discount.calculator.DiscountCalculator;
import com.app.discount.calculator.IDiscountCalculator;
import com.app.entity.Cart;
import com.app.entity.Category;
import com.app.entity.Product;
import org.mockito.Mockito;

public class BaseCartTest {

    protected Category electronic = new Category("Electronic");
    protected Category apple = new Category("Apple", electronic);
    protected Category samsung = new Category("Samsung");

    protected Product macBookPro = new Product("MacBook Pro", 10, apple);
    protected Product iPhone = new Product("iPhone", 15.99, apple);
    protected Product samsungWatch = new Product("Samsung Watch", 20, samsung);

    protected Campaign campaign1 = new Campaign(electronic, 20, 2, DiscountType.RATE);
    protected Campaign campaign2 = new Campaign(apple, 50, 2, DiscountType.AMOUNT);
    protected Campaign campaign3 = new Campaign(samsung, 60, 5, DiscountType.AMOUNT);

    protected ICartManager cartManager = Mockito.spy(new CartManager());
    protected Cart cart;
    protected IDiscountCalculator discountCalculator = Mockito.spy(new DiscountCalculator());
    protected IDiscountApplier campaignDiscountApplier = new CampaignDiscountApplier(cartManager, discountCalculator);
    protected IDiscountApplier mockCampaignDiscountApplier = Mockito.spy(campaignDiscountApplier);
    protected IDiscountApplier couponDiscountApplier = new CouponDiscountApplier(discountCalculator);
    protected IDiscountApplier mockCouponDiscountApplier = Mockito.spy(couponDiscountApplier);
    protected DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator(3, 3, Cart.DELIVERY_FIXED_COST);

}
