package com.trendyol.app.entity;

import com.trendyol.app.delivery.cost.DeliveryCostCalculator;
import com.trendyol.app.discount.applier.CampaignDiscountApplier;
import com.trendyol.app.discount.applier.CouponDiscountApplier;
import com.trendyol.app.discount.applier.IDiscountApplier;
import com.trendyol.app.discount.calculator.DiscountCalculator;
import com.trendyol.app.discount.calculator.IDiscountCalculator;
import com.trendyol.app.discount.entity.Campaign;
import com.trendyol.app.discount.entity.Coupon;
import com.trendyol.app.discount.type.DiscountType;
import com.trendyol.app.manager.cart.CartManager;
import com.trendyol.app.manager.cart.ICartManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    ICartManager cartManager = Mockito.spy(new CartManager());
    List<CartItem> cartItems = new ArrayList<>();
    Category electronicCategory = new Category("Electronic");
    Category category = new Category("Apple", electronicCategory);
    Product product = new Product("iPhone 7 Plus", 2543.99, category);
    Product product2 = new Product("iPhone 7", 2000, category);
    Cart cart;
    IDiscountCalculator discountCalculator = Mockito.spy(new DiscountCalculator());
    IDiscountApplier campaignDiscountApplier = Mockito.spy(new CampaignDiscountApplier(cartManager, discountCalculator));
    IDiscountApplier couponDiscountApplier = Mockito.spy(new CouponDiscountApplier(discountCalculator));
    Campaign campaign1 = new Campaign(category, 20, 2, DiscountType.RATE);
    Campaign campaign2 = new Campaign(category, 50, 2, DiscountType.AMOUNT);
    DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator(3, 3, Cart.DELIVERY_FIXED_COST);

    @BeforeEach
    void setUp() {
        cart = new Cart(cartManager, campaignDiscountApplier, couponDiscountApplier, deliveryCostCalculator);
    }

    @Test
    void test_AddItem_ShouldBe_CartItemsSizeOne_IfAddedOneProduct() {
        Mockito.doReturn(cartItems).when(cartManager).addItem(cart.getItems(), product, 1);

        cartItems.add(new CartItem(product, 1));
        cart.addItem(product, 1);

        assertEquals(1, cart.getItems().size());
    }

    @Test
    void test_AddItem_ShouldBe_CartItemsSizeTwo_IfAddedTwoProduct() {
        Mockito.doReturn(cartItems).when(cartManager).addItem(cart.getItems(), product, 1);

        cartItems.add(new CartItem(product, 1));
        cartItems.add(new CartItem(product2, 1));
        cart.addItem(product, 1);
        cart.addItem(product2, 1);

        assertEquals(2, cart.getItems().size());
    }

    @Test
    void test_ApplyDiscounts_ShouldBe_CartItemsSizeOne_IfAddedOneCampaign() {

        Mockito.doReturn(1.0).when(campaignDiscountApplier).apply(cart);
        cart.applyDiscounts(campaign1);

        assertEquals(1, cart.getCampaigns().size());
    }

    @Test
    void test_ApplyDiscounts_ShouldBe_CartItemsSizeTwo_IfAddedTwoCampaign() {

        Mockito.doReturn(1.0).when(campaignDiscountApplier).apply(cart);
        cart.applyDiscounts(campaign1);
        cart.applyDiscounts(campaign2);

        assertEquals(2, cart.getCampaigns().size());
    }
    @Test
    void test_ApplyCoupon_ShouldBe_Equals_IfAddedCoupon() {
        Mockito.doReturn(1.0).when(couponDiscountApplier).apply(cart);
        Coupon coupon = new Coupon(100, 10, DiscountType.RATE);
        cart.applyCoupon(coupon);

        assertEquals(coupon, cart.getCoupon());
    }

    @Test
    void test_Print() {
        cart = Mockito.spy(new Cart(cartManager, campaignDiscountApplier, couponDiscountApplier, deliveryCostCalculator));
        cartItems.add(new CartItem(product, 1));
        cartItems.add(new CartItem(product2, 1));
        Mockito.doReturn(cartItems).when(cart).getItems();

        cart.print();
    }
}