package com.app.discount.applier;

import com.app.BaseCartTest;
import com.app.entity.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class BaseDiscountApplierTest extends BaseCartTest {

    @BeforeEach
    void setUp() {
        cart = Mockito.spy(new Cart(cartManager, mockCampaignDiscountApplier, mockCouponDiscountApplier, deliveryCostCalculator));
        cart.addItem(macBookPro, 4);
        cart.addItem(iPhone, 4);
        cart.addItem(samsungWatch, 4);
    }
}
