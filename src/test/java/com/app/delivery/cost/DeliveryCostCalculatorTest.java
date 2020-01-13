package com.app.delivery.cost;

import com.app.BaseCartTest;
import com.app.entity.Cart;
import com.app.entity.CartItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeliveryCostCalculatorTest extends BaseCartTest {
    List<CartItem> cartItemList = Arrays.asList(
            new CartItem(macBookPro, 1),
            new CartItem(iPhone, 1),
            new CartItem(samsungWatch, 1)
    );
    DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator(10, 10, 3);

    @BeforeEach
    void setUp() {
        cart = Mockito.spy(new Cart(cartManager, mockCampaignDiscountApplier, mockCouponDiscountApplier, deliveryCostCalculator));
    }

    @Test
    void test_CalculateFor_ShouldBe_Equal_IfThreeProductTwoCategory() {

        Mockito.doReturn(cartItemList).when(cart).getItems();

        DeliveryCostCalculator mockDeliveryCostCalculator = Mockito.spy(deliveryCostCalculator);
        Mockito.doReturn(2).when(mockDeliveryCostCalculator).getNumberOfDeliveries(new ArrayList<>());

        assertEquals(53, mockDeliveryCostCalculator.calculateFor(cart));
    }

    @Test
    void test_GetNumberOfDeliveries_ShouldBe_ReturnTwo_IfTwoCategory() {
        assertEquals(2, deliveryCostCalculator.getNumberOfDeliveries(cartItemList));
    }
}