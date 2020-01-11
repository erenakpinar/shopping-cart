package com.app.discount.applier;

import com.app.discount.entity.Campaign;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

class CampaignDiscountApplierTest extends BaseDiscountApplierTest {
    List<Campaign> campaigns = new ArrayList<>();

    @Test
    void test_Apply_ShouldBe_Zero_IfNotAddedCampaign() {
        Assertions.assertEquals(0, campaignDiscountApplier.apply(cart));
    }

    @Test
    void test_Apply_ShouldBe_Equals_IfAddedThreeCampaign() {
        campaigns.add(campaign1);
        campaigns.add(campaign2);
        campaigns.add(campaign3);
        Mockito.doReturn(campaigns).when(cart).getCampaigns();

        Assertions.assertEquals(50, campaignDiscountApplier.apply(cart));
    }

    @Test
    void test_Apply_ShouldBe_Equals_IfAddedOneCampaign() {
        campaigns.add(campaign1);
        Mockito.doReturn(campaigns).when(cart).getCampaigns();

        Assertions.assertEquals(20.792, campaignDiscountApplier.apply(cart));
    }
}