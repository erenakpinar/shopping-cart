package com.trendyol.app.discount.applier;

import com.trendyol.app.discount.calculator.DiscountCalculator;
import com.trendyol.app.discount.calculator.IDiscountCalculator;
import com.trendyol.app.discount.entity.Campaign;
import com.trendyol.app.discount.type.DiscountType;
import com.trendyol.app.entity.Cart;
import com.trendyol.app.entity.CartItem;
import com.trendyol.app.entity.Category;
import com.trendyol.app.entity.Product;
import com.trendyol.app.manager.cart.CartManager;
import com.trendyol.app.manager.cart.ICartManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CampaignDiscountApplierTest extends BaseDiscountApplierTest {
    List<Campaign> campaigns = new ArrayList<>();

    @Test
    void test_Apply_ShouldBe_Zero_IfNotAddedCampaign() {
        assertEquals(0, campaignDiscountApplier.apply(cart));
    }

    @Test
    void test_Apply_ShouldBe_Equals_IfAddedThreeCampaign() {
        campaigns.add(campaign1);
        campaigns.add(campaign2);
        campaigns.add(campaign3);
        Mockito.doReturn(campaigns).when(cart).getCampaigns();

        assertEquals(50, campaignDiscountApplier.apply(cart));
    }

    @Test
    void test_Apply_ShouldBe_Equals_IfAddedOneCampaign() {
        campaigns.add(campaign1);
        Mockito.doReturn(campaigns).when(cart).getCampaigns();

        assertEquals(20.792, campaignDiscountApplier.apply(cart));
    }
}